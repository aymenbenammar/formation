package com.sb.formation.service;

import com.sb.formation.entities.Participant;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    ParticipantRepository participantRepository;
    @Transactional
    @Override
    public MessageResponse save(Participant participant){
        boolean exist = participantRepository.existsByEmail(participant.getEmail());
        if(exist){
            return new MessageResponse(false,"Echec !","Ce participant existe déja ! ");
        }
        participantRepository.save(participant);
        return new MessageResponse(true,"succes !","participant cree ");
    }
    @Transactional
    @Override
    public MessageResponse update(Participant participant){
        boolean exist = participantRepository.existsByEmail(participant.getEmail());
        if(!exist){
            return new MessageResponse(false,"Echec !","Ce participant n'existe pas ! ");
        }
        participantRepository.save(participant);
        return new MessageResponse(true,"succes !","participant mis a jour cree ");

    }
    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Participant participant=findById(id);
        if(participant==null){
            return new MessageResponse(false,"Echec !","Ce participant n'existe pas ! ");
        }
        participantRepository.delete(participant);
        return new MessageResponse(true,"succes !","participant supprime ");
    }
    @Override
    public List<Participant> findAll(){return participantRepository.findAll();};
    @Override
    public Participant findById(Long id){
        Participant participant = participantRepository.findById(id).orElse(null);
        return participant;
    }
}
