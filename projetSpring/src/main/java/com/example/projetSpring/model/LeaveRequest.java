package com.example.projetSpring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private boolean isApproved; // "PENDING", "APPROVED", "REJECTED"

    public LeaveRequest() {
    }

    // Constructeur avec tous les arguments
    public LeaveRequest(LocalDate startDate, LocalDate endDate, String reason, boolean isApproved, Employee employee) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.isApproved = isApproved;
        this.employee = employee;
    }
    public LeaveRequest(LocalDate startDate, LocalDate endDate, boolean isApproved, Employee employee) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isApproved = isApproved;
        this.employee = employee;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

}
