package com.example.projetSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSpring.model.Employee;
import com.example.projetSpring.model.LeaveRequest;
import com.example.projetSpring.repository.EmployeeRepository;
import com.example.projetSpring.repository.LeaveRequestRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

 @Autowired
    private EmployeeRepository employeeRepository;

    
    public LeaveRequest createLeaveRequest(LocalDate startDate, LocalDate endDate, String reason, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            LeaveRequest leaveRequest = new LeaveRequest(startDate, endDate, reason, false, employee);
            if (employee.getLeaveRequests() == null) {
                employee.setLeaveRequests(new ArrayList<>());
            }
            employee.getLeaveRequests().add(leaveRequest);

            // Sauvegarder l'employé avec la liste mise à jour
            employeeRepository.save(employee);
            return leaveRequestRepository.save(leaveRequest);
        }
        return null;
    }

    public LeaveRequest createLeaveRequestSRaison(LocalDate startDate, LocalDate endDate, Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            LeaveRequest leaveRequest = new LeaveRequest(startDate, endDate, false, employee);
            // Ajouter la demande de congé à la liste des demandes de l'employé
            if (employee.getLeaveRequests() == null) {
                employee.setLeaveRequests(new ArrayList<>());
            }
            employee.getLeaveRequests().add(leaveRequest);

            // Sauvegarder l'employé avec la liste mise à jour
            employeeRepository.save(employee);
            return leaveRequestRepository.save(leaveRequest);
        }
        return null;
    }
    public void approveLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setApproved(true);
            leaveRequestRepository.save(leaveRequest);
        }
    }

    public void rejectLeaveRequest(Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setApproved(false);
            leaveRequestRepository.save(leaveRequest);
        }
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id).orElse(null);
    }

    public LeaveRequest updateLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
