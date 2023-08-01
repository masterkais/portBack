package com.port.service.implService;

import com.port.persistance.dao.SortieDao;
import com.port.persistance.entities.Sortie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortieService {
    @Autowired
    SortieDao sortieDao;
    public Sortie save(Sortie sortie){
        return  this.sortieDao.saveAndFlush(sortie);
    }
    public Sortie update(Sortie sortie){
      return  this.sortieDao.saveAndFlush(sortie);
    }
   public void delete(Long id){
        this.sortieDao.deleteById(id);
    }
    public Sortie getById(Long id){
        return this.sortieDao.findById(id).get();
    }
    public List<Sortie> getAll(){
      return  this.sortieDao.findAll();
    }
}