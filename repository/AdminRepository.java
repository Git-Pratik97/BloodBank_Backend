package com.bnl.bloodbank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bnl.bloodbank.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);
    
}
