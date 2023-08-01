package com.port.persistance.dao;

import com.port.persistance.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupDao extends JpaRepository<Group, Long> {
    Group findByPrivileged(String privileged);

    List<Group> findByIdIn(List<Long> ids);

    @Query(value = "select groups_gr_id from t_user_groups where user_u_id = :id", nativeQuery = true)
    List<Long> getAllGroupsIdByIdUser(@Param("id") Long id);

}
