package com.port.service.implService;

import com.port.persistance.dao.CombustibleDao;
import com.port.persistance.dao.SortieDao;
import com.port.persistance.entities.Combustible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombustibleService {
    @Autowired
    CombustibleDao combustibleDao;
    public Combustible save(Combustible combustible){
     return this.combustibleDao.saveAndFlush(combustible);
    }
    public Combustible update(Combustible combustible){
        return this.combustibleDao.saveAndFlush(combustible);
    }
    public void delete(Long id){
        this.combustibleDao.deleteById(id);
    }
    public Combustible getById(Long id){
        return this.combustibleDao.findById(id).get();
    }
    public List<Combustible> getAll(){
      return this.combustibleDao.findAll();
    }
}
