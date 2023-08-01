package com.port.persistance.dao;


import com.port.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String firstName);

    User findByLoginAndPassword(String login, String password);

    @Query(value = "select * from t_user_groups where groups_gr_id = :id", nativeQuery = true)
    List<Long> getAllUsersIdByIdGroups(@Param("id") Long id);

}
