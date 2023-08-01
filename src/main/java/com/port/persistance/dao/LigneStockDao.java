package com.port.persistance.dao;

import com.port.persistance.entities.LigneStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneStockDao extends JpaRepository<LigneStock, Long> {
}
