package com.sb.formation.repository;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Long> {
    boolean existsByEmail(String email);
}
