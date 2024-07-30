package com.example.projetSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projetSpring.model.RH;


@Repository
public interface RHRepository extends JpaRepository<RH, Long> {
}