package com.example.projetSpring.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.example.projetSpring.model.Employee;
import com.example.projetSpring.model.Salary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {
     
}
