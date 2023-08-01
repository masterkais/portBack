package com.port.service.interfaceService;


import com.port.persistance.entities.User;

import java.util.List;

public interface IUserService {
    User save(User User);

    User update(User user);

    User findById(Long id);

    List<User> findAllUsers();

    void delete(Long id);

    User findUserByName(String userName);

    void addPrevilegeToUser(String userName, String privileged);

    List<User> findUsersByPrivilege(String privilege);
}
