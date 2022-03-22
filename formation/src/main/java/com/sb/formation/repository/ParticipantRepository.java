package com.sb.formation.repository;

import com.sb.formation.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
    Boolean existsByEmail(String email);
}
