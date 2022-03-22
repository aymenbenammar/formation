package com.sb.formation.controller;

import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ProfilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/profil")
public class ProfilController {
    @Autowired
    private ProfilServiceImpl profilService;

    //@RequestMapping(value="/domaine", method=RequestMethod.GET)
    @GetMapping
    public List<Profil> findAll() {
        return profilService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Profil profil) {
        return profilService.save(profil);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Profil profil) {
        return profilService.update(profil);
    }

    @GetMapping("/{code}")
    public Profil findById(@PathVariable("code") Long id) {
        return profilService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return profilService.delete(id);
    }
}
