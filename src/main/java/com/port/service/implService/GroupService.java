package com.port.service.implService;


import com.port.persistance.dao.GroupDao;
import com.port.persistance.dao.UserDao;
import com.port.persistance.entities.Group;
import com.port.persistance.entities.User;
import com.port.persistance.errors.ApiErrors;
import com.port.service.interfaceService.IGroupService;
import com.port.service.utils.http.HttpCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void addRoleToUse(String userName, String roleName) {
        Group group = groupDao.findByPrivileged(roleName);
        User user = userDao.findByLogin(userName);
        user.getGroups().add(group);
        userDao.save(user);
    }

    @Override
    public Group save(Group groupDto) {
        Objects.requireNonNull(groupDto);
        if (groupDao.findByPrivileged(groupDto.getPrivileged()) != null) {
            throw new HttpCustomException(ApiErrors.OBJECT_EXISTS);
        }
        Group groupeSaved = groupDao.saveAndFlush(groupDto);
        return groupDto;
    }

    @Override
    public Group update(Group groupDto) {
        Objects.requireNonNull(groupDto);
        if (groupDao.findByPrivileged(groupDto.getPrivileged()) != null) {
            throw new HttpCustomException(ApiErrors.OBJECT_EXISTS);
        }
        Group group = groupDao.findById(groupDto.getId()).get();
        group.setPrivileged(groupDto.getPrivileged());
        Group groupeSaved = groupDao.saveAndFlush(group);
        return groupeSaved;
    }

    @Override
    public Group findById(Long id) {
        return Optional.ofNullable(groupDao.findById(id).get()).orElseThrow(
                () -> new HttpCustomException(ApiErrors.ENTITY_NOT_FOUND));

    }

    @Override
    public List<Group> findAllEGroupe() {
        List<Group> groups = groupDao.findAll();
        return groups;
    }

    @Override
    public void delete(Long id) {
        groupDao.deleteById(id);
    }

    @Override
    public Group findByPrivileged(String nom) {
        return Optional.ofNullable(groupDao.findByPrivileged(nom)).orElseThrow(
                () -> new HttpCustomException(ApiErrors.ENTITY_NOT_FOUND));

    }

    public List<Group> findAllGroupByUserId(Long idUser) {
        List<Long> groupIds = this.groupDao.getAllGroupsIdByIdUser(idUser);
        List<Group> groupDtos = new ArrayList<>();
        groupIds.forEach((idGroup) -> {
            Group group = this.groupDao.findById(idGroup).get();
            groupDtos.add(group);
        });
        return groupDtos;
    }
}
