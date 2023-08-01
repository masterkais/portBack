package com.port.service.implService;

import com.port.persistance.dao.DieselDao;
import com.port.persistance.dao.SortieDao;
import com.port.persistance.entities.Diesel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DieselService {
    @Autowired
    DieselDao dieselDao;
    public Diesel save(Diesel diesel){
    return this.dieselDao.saveAndFlush(diesel);
    }
    public Diesel update(Diesel diesel){
        return this.dieselDao.saveAndFlush(diesel);
    }
    public void delete(Long id){
        this.dieselDao.deleteById(id);
    }
    public Diesel getById(Long id){
        return this.dieselDao.findById(id).get();
    }
    public List<Diesel> getAll(){
     return this.dieselDao.findAll();
    }
}
