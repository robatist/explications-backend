package com.robatist.backend.backend.repository;

import com.robatist.backend.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
