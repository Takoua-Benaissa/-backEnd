package com.example.projetSpring.model;

import jakarta.persistence.*;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;  // L'employé concerné

    @Column(nullable = false)
    private double baseSalary;  // Salaire de base

    private double totalBonuses;  // Somme de toutes les primes
    private double totalSalary;  // Salaire total = baseSalary + totalBonuses

    public Salary() {
    }

    public Salary(Employee employee, double baseSalary) {
        this.employee = employee;
        this.baseSalary = baseSalary;
        this.totalBonuses = 0;
        this.totalSalary = baseSalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        calculateTotalSalary();
    }

    public double getTotalBonuses() {
        return totalBonuses;
    }

    public void setTotalBonuses(double totalBonuses) {
        this.totalBonuses = totalBonuses;
        calculateTotalSalary();
    }

    public double getTotalSalary() {
        return totalSalary;
    }
    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    private void calculateTotalSalary() {
        this.totalSalary = this.baseSalary + this.totalBonuses;
    }
}
