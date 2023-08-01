package com.port.service.implService;

import com.port.constants.Constants;
import com.port.persistance.dao.GroupDao;
import com.port.persistance.dao.UserDao;
import com.port.persistance.entities.Group;
import com.port.persistance.entities.User;
import com.port.persistance.errors.ApiErrors;
import com.port.service.interfaceService.IUserService;
import com.port.service.utils.errors.ErrorsResponse;
import com.port.service.utils.http.HttpCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService(UserDao userDao, GroupDao groupDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByName(String userName) {
        User user = userDao.findByLogin(userName);
        List<Group> groups = new ArrayList<>();
        List<Long> groupsIds = this.groupDao.getAllGroupsIdByIdUser(user.getId());
        groupsIds.forEach((id) -> {
            groups.add(this.groupDao.findById(id).get());
        });
        user.setGroups(groups);
        return userDao.findByLogin(userName);
    }

    @Override
    public User save(User userDto) {
        Objects.requireNonNull(userDto);
        userDto.setActive(false);
        if (userDao.findByLogin(userDto.getLogin()) != null) {
            throw new RuntimeException("this user aleready exist");
        }
        String hachPW = bCryptPasswordEncoder.encode(userDto.getPassword());
        userDto.setPassword(hachPW);
        System.out.println(userDto.getGroups());
        User savedUser = userDao.saveAndFlush(userDto);
        return userDto;
    }

    @Override
    public User update(User userDto) {
        User savedUser = userDao.saveAndFlush(userDto);
        log.info(Constants.LOG_ENTITY_UPDATED, savedUser);
        return savedUser;
    }

    @Override
    public User findById(Long id) {
        return Optional.ofNullable(userDao.findById(id).get()).orElseThrow(
                () -> new HttpCustomException(ApiErrors.ENTITY_NOT_FOUND, new ErrorsResponse().error(id)));
    }

    @Override
    public List<User> findAllUsers() {
        List<User> usertList = userDao.findAll();
        List<User> userDtos = new ArrayList<>();
        usertList.forEach(user -> {
            userDtos.add(user);
        });
        return userDtos;
    }


    @Override
    public void addPrevilegeToUser(String userName, String privileged) {
        User user = userDao.findByLogin(userName);
        Group group = groupDao.findByPrivileged(privileged);
        user.getGroups().add(group);
        userDao.saveAndFlush(user);
    }

    @Override
    public List<User> findUsersByPrivilege(String privilege) {
        Group group = groupDao.findByPrivileged(privilege);
        System.out.println(group.getPrivileged());
        List<Long> usersIds = new ArrayList<>();
        usersIds = userDao.getAllUsersIdByIdGroups(group.getId());
        System.out.println(usersIds.size());
        List<User> userDtoList = new ArrayList<>();
        usersIds.forEach((usersId) -> {
            User user = userDao.findById(usersId).get();
            if (user != null) {
                userDtoList.add(user);
            }
        });
        return userDtoList;
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

}
