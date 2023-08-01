package com.port.service.restController;


import com.port.persistance.entities.Group;
import com.port.persistance.entities.Sortie;
import com.port.service.implService.SortieService;
import com.port.service.interfaceService.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/sortie")
public class SortieController {
    @Autowired
    private  SortieService sortieService;


    @GetMapping(value = "/sorties")
    public List<Sortie> findAll() {
        return sortieService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Sortie getSortie(@PathVariable Long id) {
        return sortieService.getById(id);
    }

    @PostMapping()
    public Sortie save(@RequestBody Sortie sortie) {
        return sortieService.save(sortie);
    }

    @PutMapping()
    public Sortie update(@RequestBody Sortie sortie) {
        return sortieService.update(sortie);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        sortieService.delete(id);
        return true;
    }

}
