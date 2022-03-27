package com.sb.formation.service;

import com.sb.formation.entities.Organisme;
import com.sb.formation.entities.Session;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{
    @Autowired
    SessionRepository sessionRepository;
    @Transactional
    @Override
    public MessageResponse save(Session session) {

        boolean exist =sessionRepository.existsById(session.getId());
        if(exist){
            return new MessageResponse(false,"Echec !","Cette session existe déja ! ");
        }

        sessionRepository.save(session);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse update(Session session) {
        boolean exist =sessionRepository.existsById(session.getId());
        if(!exist){
            return new MessageResponse(false,"Echec !","Cet organisme  n'existe pas ! ");
        }
        sessionRepository.save(session);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Session session=findById(id);
        if(session==null){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }

        sessionRepository.delete(session);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session findById(Long id) {
        Session session = sessionRepository.findById(id).orElse(null);
        return session;
    }
}
