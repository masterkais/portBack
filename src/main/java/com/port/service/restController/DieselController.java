package com.port.service.restController;


import com.port.persistance.entities.Diesel;
import com.port.persistance.entities.Group;
import com.port.service.implService.DieselService;
import com.port.service.interfaceService.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/diesel")
public class DieselController {
    @Autowired
    private DieselService dieselService;


    @GetMapping(value = "/diesel")
    public List<Diesel> findAll() {
        return dieselService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Diesel getDiesel(@PathVariable Long id) {
        return dieselService.getById(id);
    }


    @PostMapping()
    public Diesel save(@RequestBody @Valid Diesel d) {
        return dieselService.save(d);
    }

    @PutMapping()
    public Diesel update(@RequestBody @Valid Diesel d) {
        return dieselService.update(d);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        dieselService.delete(id);
        return true;
    }

}
