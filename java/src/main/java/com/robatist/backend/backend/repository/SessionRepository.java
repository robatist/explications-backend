package com.robatist.backend.backend.repository;

import com.robatist.backend.backend.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
