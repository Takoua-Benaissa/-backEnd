package com.example.projetSpring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.projetSpring.model.Employee;
import com.example.projetSpring.repository.EmployeeRepository;

public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployeeCin(Long employeeId, String newCin) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setCin(newCin);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeeNom(Long employeeId, String newNom) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setNom(newNom);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeePrenom(Long employeeId, String newPrenom) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setPrenom(newPrenom);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeeDateDeNaissance(Long employeeId, Date newDateDeNaissance) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setDateDeNaissance(newDateDeNaissance);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeePosition(Long employeeId, String newPosition) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setPosition(newPosition);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeeEmail(Long employeeId, String newEmail) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setEmail(newEmail);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeeAdresse(Long employeeId, String newAdresse) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setAdresse(newAdresse);
            employeeRepository.save(employee);
        }
        return employee;
    }

    public Employee updateEmployeeTelephone(Long employeeId, String newTelephone) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setTelephone(newTelephone);
            employeeRepository.save(employee);
        }
        return employee;
    }
    
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
