package com.demo.barogo.jpa.repository;

import com.demo.barogo.jpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long>   {
    Optional<Users> findById(String id);
}


