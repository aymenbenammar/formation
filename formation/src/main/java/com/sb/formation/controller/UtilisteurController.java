package com.sb.formation.controller;


import com.sb.formation.entities.Utilisateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/utilisateur")
public class UtilisteurController {
    @Autowired
    private UtilisateurServiceImpl utilisateurService;
    @GetMapping
    public List<Utilisateur> findAll(){return utilisateurService.findAll();}
    @PostMapping
    public MessageResponse save(@RequestBody Utilisateur utilisateur){return utilisateurService.save(utilisateur);}
    @PutMapping
    public MessageResponse update(@RequestBody Utilisateur utilisateur){return utilisateurService.update(utilisateur);}
    @DeleteMapping("/{code}")
    public MessageResponse delete(@PathVariable("code") Long code) {return utilisateurService.delete(code);}
    @GetMapping("/{code}")
    public Utilisateur findById(@PathVariable("code") Long code){return utilisateurService.findById(code);}

}
