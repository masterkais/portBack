package com.port.persistance.dao;

import com.port.persistance.entities.Diesel;
import com.port.persistance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DieselDao extends JpaRepository<Diesel, Long> {
}
