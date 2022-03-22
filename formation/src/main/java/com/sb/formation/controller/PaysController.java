package com.sb.formation.controller;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.DomaineServiceImpl;
import com.sb.formation.service.PaysServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pays")
public class PaysController {
    @Autowired
    private PaysServiceImpl paysService;

    @GetMapping
    public List<Pays> findAll() {
        return paysService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Pays pays) {
        return paysService.save(pays);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Pays pays) {
        return paysService.update(pays);
    }

    @GetMapping("/{code}")
    public Pays  findById(@PathVariable("code") Long id) {
        return paysService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return paysService.delete(id);
    }
}
