package com.sb.formation.repository;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
    boolean existsByLibelle(String libelle);
}
