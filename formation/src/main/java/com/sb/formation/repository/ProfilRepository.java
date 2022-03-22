package com.sb.formation.repository;

import com.sb.formation.entities.Domaine;
import com.sb.formation.entities.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
    boolean existsByLibelle(String libelle);
}
