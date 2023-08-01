package com.port.service.interfaceService;

import com.port.persistance.entities.Group;

import java.util.List;

public interface IGroupService {
    Group save(Group groupDto);

    Group update(Group group);

    Group findById(Long id);

    void addRoleToUse(String userName, String roleName);

    List<Group> findAllEGroupe();

    void delete(Long id);

    Group findByPrivileged(String nom);
}
