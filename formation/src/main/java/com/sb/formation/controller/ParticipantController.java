package com.sb.formation.controller;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.ParticipantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/participant")
public class ParticipantController {
    @Autowired
    ParticipantServiceImpl participantService;
    @GetMapping
    public List<Participant> findAll(){return participantService.findAll();}
    @PostMapping
    public MessageResponse save(@RequestBody Participant participant) {return participantService.save(participant);}
    @PutMapping
    public  MessageResponse update(@RequestBody Participant participant) {return participantService.update(participant);}
    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Long id){return participantService.delete(id);}
    @GetMapping("/{id}")
    public Participant findById(@PathVariable("id") Long id) {return participantService.findById(id);}
}
