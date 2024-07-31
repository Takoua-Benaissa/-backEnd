package com.example.projetSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projetSpring.model.Bonus;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {
}
