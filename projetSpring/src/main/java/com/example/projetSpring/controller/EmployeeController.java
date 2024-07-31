package com.example.projetSpring.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projetSpring.model.Employee;
import com.example.projetSpring.service.EmployeeService;


public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

     @PutMapping("/{id}/cin")
    public ResponseEntity<Employee> updateEmployeeCin(@PathVariable Long id, @RequestParam String newCin) {
        Employee updatedEmployee = employeeService.updateEmployeeCin(id, newCin);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/nom")
    public ResponseEntity<Employee> updateEmployeeNom(@PathVariable Long id, @RequestParam String newNom) {
        Employee updatedEmployee = employeeService.updateEmployeeNom(id, newNom);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/prenom")
    public ResponseEntity<Employee> updateEmployeePrenom(@PathVariable Long id, @RequestParam String newPrenom) {
        Employee updatedEmployee = employeeService.updateEmployeePrenom(id, newPrenom);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/dateDeNaissance")
    public ResponseEntity<Employee> updateEmployeeDateDeNaissance(@PathVariable Long id, @RequestParam Date newDateDeNaissance) {
        Employee updatedEmployee = employeeService.updateEmployeeDateDeNaissance(id, newDateDeNaissance);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/position")
    public ResponseEntity<Employee> updateEmployeePosition(@PathVariable Long id, @RequestParam String newPosition) {
        Employee updatedEmployee = employeeService.updateEmployeePosition(id, newPosition);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Employee> updateEmployeeEmail(@PathVariable Long id, @RequestParam String newEmail) {
        Employee updatedEmployee = employeeService.updateEmployeeEmail(id, newEmail);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/adresse")
    public ResponseEntity<Employee> updateEmployeeAdresse(@PathVariable Long id, @RequestParam String newAdresse) {
        Employee updatedEmployee = employeeService.updateEmployeeAdresse(id, newAdresse);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PutMapping("/{id}/telephone")
    public ResponseEntity<Employee> updateEmployeeTelephone(@PathVariable Long id, @RequestParam String newTelephone) {
        Employee updatedEmployee = employeeService.updateEmployeeTelephone(id, newTelephone);
        return ResponseEntity.ok(updatedEmployee);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    
}
