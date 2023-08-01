package com.port.service.restController;


import com.port.persistance.entities.Combustible;
import com.port.persistance.entities.Group;
import com.port.service.implService.CombustibleService;
import com.port.service.interfaceService.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/combustible")
public class CombustibleController {
    @Autowired
    private CombustibleService combustibleService;

    @GetMapping(value = "/combustibles")
    public List<Combustible> findAll() {
        return combustibleService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Combustible getCombustible(@PathVariable Long id) {
        return combustibleService.getById(id);
    }

    @PostMapping()
    public Combustible save(@RequestBody @Valid Combustible combustible) {
        return combustibleService.save(combustible);
    }

    @PutMapping()
    public Combustible update(@RequestBody @Valid Combustible combustible) {
        return combustibleService.update(combustible);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        combustibleService.delete(id);
        return true;
    }

}
