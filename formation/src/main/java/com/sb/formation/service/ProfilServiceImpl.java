package com.sb.formation.service;

import com.sb.formation.entities.Pays;
import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.PaysRepository;
import com.sb.formation.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfilServiceImpl implements ProfilService {
    @Autowired
    ProfilRepository profilRepository;
    @Transactional
    @Override
    public MessageResponse save(Profil profil) {

        boolean exist =profilRepository.existsByLibelle(profil.getLibelle());
        if(exist){
            return new MessageResponse(false,"Echec !","Ce pays existe déja ! ");
        }

        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse update(Profil profil) {
        boolean exist =profilRepository.existsByLibelle(profil.getLibelle());
        if(!exist){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }
        profilRepository.save(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Profil profil=findById(id);
        if(profil==null){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }

        profilRepository.delete(profil);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }

    @Override
    public List<Profil> findAll() {
        return profilRepository.findAll();
    }

    @Override
    public Profil findById(Long id) {
        Profil profil = profilRepository.findById(id).orElse(null);
        return profil;
    }
}
