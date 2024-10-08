package com.bnl.bloodbank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bnl.bloodbank.entity.Hospital;
import com.bnl.bloodbank.entity.Request;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findByUsername(String username);

    Optional<Hospital> findByMobileNumber(long mobileNumber);

    @Query("SELECT h.requests from Hospital h where h.hospitalId = :id")
    List<Request> findRequests(long id);

    @Query("SELECT r from Hospital h inner join Request r on h.hospitalId = r.hospital.hospitalId where h.hospitalId = :id and r.status = 'pending'")
    List<Request> findPendingRequest(long id);
    
}
