package com.port.persistance.dao;

import com.port.persistance.entities.Combustible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombustibleDao extends JpaRepository<Combustible, Long> {
}
