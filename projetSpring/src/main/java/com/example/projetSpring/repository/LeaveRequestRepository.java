package com.example.projetSpring.repository;

import com.example.projetSpring.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;


//@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}