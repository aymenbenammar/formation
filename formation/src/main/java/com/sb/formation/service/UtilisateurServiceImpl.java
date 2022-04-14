package com.sb.formation.service;

import com.sb.formation.entities.Utilisateur;
import com.sb.formation.reponses.MessageResponse;
import com.sb.formation.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Transactional
    @Override
    public MessageResponse save(Utilisateur utilisateur){
        boolean exist =utilisateurRepository.existsByUsername(utilisateur.getUsername());
        if (exist){
            return new MessageResponse(false,"Echec !","Cet utilisateur existe déja ! ");
        }
        utilisateurRepository.save(utilisateur);
        return new MessageResponse(true,"succes !","utilisateur cree ");

    }
    @Transactional
    @Override
    public MessageResponse update(Utilisateur utilisateur){
        boolean exist =utilisateurRepository.existsByUsername(utilisateur.getUsername());
        if (!exist){
            return new MessageResponse(false,"Echec !","Cet utilisateur n'existe pas ! ");
        }
        utilisateurRepository.save(utilisateur);
        return new MessageResponse(true,"succes !","utilisateur mis a jour ");

    }
    @Transactional
    @Override
    public MessageResponse delete(Long id){
        Utilisateur utilisateur=findById(id);
        if (utilisateur==null){
            return new MessageResponse(false,"Echec !","Cet utilisateur n'existe pas ! ");
        }
        utilisateurRepository.delete(utilisateur);
        return new MessageResponse(true,"succes !","utilisateur effacé ");

    }
    @Override
    public List<Utilisateur> findAll(){
        return utilisateurRepository.findAll();
    }
    @Override
    public Utilisateur findById(Long id){
        Utilisateur utilisateur= utilisateurRepository.findById(id).orElse(null);
        return utilisateur;
    }
}
