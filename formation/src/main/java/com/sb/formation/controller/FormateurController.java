package com.sb.formation.controller;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Formateur;
import com.sb.formation.reponses.MessageResponse;

import com.sb.formation.service.FormateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/formateur")
public class FormateurController {
    @Autowired
    private FormateurServiceImpl formateurService;


    @GetMapping
    public List<Formateur> findAll() {
        return formateurService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Formateur formateur) {
        return formateurService.save(formateur);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Formateur formateur) {
        return formateurService.update(formateur);
    }

    @GetMapping("/{code}")
    public Formateur findById(@PathVariable("code") Long id) {
        return formateurService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return formateurService.delete(id);
    }
}
