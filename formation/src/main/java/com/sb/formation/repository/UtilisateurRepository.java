package com.sb.formation.repository;

import com.sb.formation.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    boolean existsByUsername(String login);
    Optional<Utilisateur> findByUsername(String username);
}
