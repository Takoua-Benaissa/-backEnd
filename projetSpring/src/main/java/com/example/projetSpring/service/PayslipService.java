package com.example.projetSpring.service;

//import com.example.projetSpring.model.Employee;
import com.example.projetSpring.model.Payslip;
import com.example.projetSpring.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    public List<Payslip> getAllPayslips() {
        return payslipRepository.findAll();
    }

    public Optional<Payslip> getPayslipById(Long id) {
        return payslipRepository.findById(id);
    }

    public Payslip createPayslip(Payslip payslip) {
        return payslipRepository.save(payslip);
    }

    public Payslip updatePayslip(Long id, Payslip payslipDetails) {
        Payslip payslip = payslipRepository.findById(id).orElseThrow(() -> new RuntimeException("Payslip not found"));
        payslip.setEmployeeId(payslipDetails.getEmployeeId());
        payslip.setAmount(payslipDetails.getAmount());
        payslip.setDateIssued(payslipDetails.getDateIssued());
        return payslipRepository.save(payslip);
    }

    public void deletePayslip(Long id) {
        payslipRepository.deleteById(id);
    }
}
