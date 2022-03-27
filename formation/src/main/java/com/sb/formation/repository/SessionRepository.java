package com.sb.formation.repository;

import com.sb.formation.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
    boolean existsById(Long id);
}
