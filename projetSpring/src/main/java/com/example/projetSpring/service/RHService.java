package com.example.projetSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetSpring.model.Employee;
import com.example.projetSpring.model.LeaveRequest;
import com.example.projetSpring.model.RH;
import com.example.projetSpring.repository.EmployeeRepository;
import com.example.projetSpring.repository.LeaveRequestRepository;
import com.example.projetSpring.repository.RHRepository;

@Service
public class RHService {
    @Autowired
    private RHRepository rhRepository;

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public RH getRHById(Long id) {
        return rhRepository.findById(id).orElse(null);
    }

    public void approveLeaveRequest(Long requestId) {
        LeaveRequest request = leaveRequestRepository.findById(requestId).orElse(null);
        if (request != null) {
            request.setApproved(true);
            leaveRequestRepository.save(request);
        }
    }

    public void rejectLeaveRequest(Long requestId) {
        LeaveRequest request = leaveRequestRepository.findById(requestId).orElse(null);
        if (request != null) {
            request.setApproved(false);
            leaveRequestRepository.save(request);
        }
    }

    public void updateEmployeeInfo(Long employeeId, String newAddress, String newPhone) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setAdresse(newAddress);
            employee.setTelephone(newPhone);
            employeeRepository.save(employee);
        }
    }

    public void assignSalary(Long employeeId, double newSalary) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setSalaire(newSalary);
            employeeRepository.save(employee);
        }
    }

    public void assignBonus(Long employeeId, double bonus) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
            employee.setSalaire(employee.getSalaire() + bonus);
            employeeRepository.save(employee);
        }
    }
}
