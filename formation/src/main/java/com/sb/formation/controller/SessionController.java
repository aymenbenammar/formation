package com.sb.formation.controller;

import com.sb.formation.entities.Organisme;
import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.service.OrganismeServiceImpl;
import com.sb.formation.service.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private SessionServiceImpl sessionService;


    @GetMapping
    public List<Session> findAll() {
        return sessionService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Session session) {
        return sessionService.save(session);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Session session) {
        return sessionService.update(session);
    }

    @GetMapping("/{id}")
    public Session findById(@PathVariable("id") Long id) {
        return sessionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable Long id) {
        return sessionService.delete(id);
    }
}
