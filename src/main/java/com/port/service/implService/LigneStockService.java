package com.port.service.implService;

import com.port.persistance.dao.LigneStockDao;
import com.port.persistance.entities.LigneStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneStockService {
    @Autowired
    LigneStockDao ligneStockDao;

    public LigneStock save(LigneStock ligneStock) {
        return this.ligneStockDao.saveAndFlush(ligneStock);
    }

    public LigneStock update(LigneStock ligneStock) {
        return this.ligneStockDao.saveAndFlush(ligneStock);
    }

    public void delete(Long id) {
        this.ligneStockDao.deleteById(id);
    }

    public LigneStock getById(Long id) {
        return this.ligneStockDao.findById(id).get();
    }

    public List<LigneStock> getAll() {
        return this.ligneStockDao.findAll();
    }
}
