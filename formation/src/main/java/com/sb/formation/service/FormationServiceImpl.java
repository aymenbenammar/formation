package com.sb.formation.service;

import com.sb.formation.entities.Formation;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.util.List;

@Service
public class FormationServiceImpl implements FormationService{
    @Autowired
    FormationRepository formationRepository;
    @Transactional
    @Override
    public MessageResponse save(Formation formation){
        boolean exist= formationRepository.existsByTitre(formation.getTitre());
        if(exist){
            return new MessageResponse(false,"Echec !","Cette formation existe déja ! ");
        }
        formationRepository.save(formation);
        return new MessageResponse(true,"succes !","formation cree ");
    }
    @Transactional
    @Override
    public MessageResponse update(Formation formation){
        boolean exist= formationRepository.existsByTitre(formation.getTitre());
        if(!exist){
            return new MessageResponse(false,"Echec !","Cette formation n'existe pas ! ");
        }
        formationRepository.save(formation);
        return new MessageResponse(true,"succes !","formation mise a jour ");
    }
    @Transactional
    @Override
    public MessageResponse delete(Long id){
        Formation formation =findById(id);
        if(formation==null){
            return new MessageResponse(false,"Echec !","Cette formation n'existe pas ! ");
        }
        formationRepository.delete(formation);
        return new MessageResponse(true,"succes !","formation supprime ");
    }
    @Override
    public List<Formation> findAll(){
        return formationRepository.findAll();
    }
    @Override
    public  Formation findById(Long id){
        Formation formation= formationRepository.findById(id).orElse(null);
        return formation;
    }
}
