package com.robatist.backend.repository;

import com.robatist.backend.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
