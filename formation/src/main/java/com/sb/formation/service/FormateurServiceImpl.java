package com.sb.formation.service;

import com.sb.formation.entities.Formateur;
import com.sb.formation.entities.Profil;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.FormateurRepository;
import com.sb.formation.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService{
    @Autowired
    FormateurRepository formateurRepository;
    @Transactional
    @Override
    public MessageResponse save(Formateur formateur) {

        boolean exist =formateurRepository.existsByEmail(formateur.getEmail());
        if(exist){
            return new MessageResponse(false,"Echec !","Ce pays existe déja ! ");
        }

        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse update(Formateur formateur) {
        boolean exist =formateurRepository.existsByEmail(formateur.getEmail());
        if(!exist){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }
        formateurRepository.save(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }
    @Transactional
    @Override
    public MessageResponse delete(Long id) {
        Formateur formateur=findById(id);
        if(formateur==null){
            return new MessageResponse(false,"Echec !","Ce pays n'existe pas ! ");
        }

        formateurRepository.delete(formateur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");


    }

    @Override
    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur findById(Long id) {
        Formateur formateur = formateurRepository.findById(id).orElse(null);
        return formateur;
    }
}
