package com.sb.formation.service;

import com.sb.formation.entities.Pays;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaysServiceImpl implements PaysService {


    @Autowired
    PaysRepository paysRepository;
    @Transactional
    @Override
    public MessageResponse save(Pays pays) {

        boolean exist =paysRepository.existsByLibelle(pays.getLibelle());
        if(exist){
            return new MessageResponse(false,"Echec !","Ce pays existe déja ! ");
        }

            paysRepository.save(pays);
            return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


        }
    @Transactional
    @Override
    public MessageResponse update(Pays pays) {
        boolean exist =paysRepository.existsByLibelle(pays.getLibelle());
        if(!exist){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }
            paysRepository.save(pays);
            return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Pays pays=findById(id);
        if(pays==null){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }

            paysRepository.delete(pays);
            return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }

    @Override
    public List<Pays> findAll() {
        return paysRepository.findAll();
    }

    @Override
    public Pays findById(Long id) {
        Pays pays = paysRepository.findById(id).orElse(null);
        return pays;
    }
}
