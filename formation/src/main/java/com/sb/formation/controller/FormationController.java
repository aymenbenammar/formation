package com.sb.formation.controller;

import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.FormationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/formation")
public class FormationController {
    @Autowired
    FormationServiceImpl formationService;
    @GetMapping
    public List<Formation> findAll(){return formationService.findAll();}
    @PutMapping
    public MessageResponse update(@RequestBody Formation formation){return formationService.update(formation);}
    @PostMapping
    public MessageResponse save(@RequestBody Formation formation){return  formationService.save(formation);}
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Long id){return formationService.delete(id);}
    @GetMapping("{id}")
    public Formation findById(@PathVariable("id") Long id) {return formationService.findById(id);}
}
