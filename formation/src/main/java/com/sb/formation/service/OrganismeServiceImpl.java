package com.sb.formation.service;

import com.sb.formation.entities.Organisme;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.OrganismeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganismeServiceImpl implements OrganismeService{
    @Autowired
    OrganismeRepository organismeRepository;
    @Transactional
    @Override
    public MessageResponse save(Organisme organisme) {

        boolean exist =organismeRepository.existsByLibelle(organisme.getLibelle());
        if(exist){
            return new MessageResponse(false,"Echec !","Cet organiste existe déja ! ");
        }

        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse update(Organisme organisme) {
        boolean exist =organismeRepository.existsByLibelle(organisme.getLibelle());
        if(!exist){
            return new MessageResponse(false,"Echec !","Cet organisme  n'existe pas ! ");
        }
        organismeRepository.save(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Organisme organisme=findById(id);
        if(organisme==null){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }

        organismeRepository.delete(organisme);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }

    @Override
    public List<Organisme> findAll() {
        return organismeRepository.findAll();
    }

    @Override
    public Organisme findById(Long id) {
        Organisme organisme = organismeRepository.findById(id).orElse(null);
        return organisme;
    }
}
