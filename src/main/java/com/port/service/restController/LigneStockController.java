package com.port.service.restController;


import com.port.persistance.entities.LigneStock;
import com.port.service.implService.LigneStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ligneStock")
public class LigneStockController {
    @Autowired
    private LigneStockService ligneStockService;


    @GetMapping(value = "/ligneStocks")
    public List<LigneStock> findAll() {
        return ligneStockService.getAll();
    }

    @GetMapping(value = "/{id}")
    public LigneStock getLigneStock(@PathVariable Long id) {
        return ligneStockService.getById(id);
    }


    @PostMapping()
    public LigneStock save(@RequestBody @Valid LigneStock l) {
        return ligneStockService.save(l);
    }

    @PutMapping()
    public LigneStock update(@RequestBody @Valid LigneStock l) {
        return ligneStockService.update(l);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        ligneStockService.delete(id);
        return true;
    }

}
