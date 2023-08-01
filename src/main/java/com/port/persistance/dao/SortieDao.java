package com.port.persistance.dao;

import com.port.persistance.entities.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortieDao extends JpaRepository<Sortie, Long> {
}
