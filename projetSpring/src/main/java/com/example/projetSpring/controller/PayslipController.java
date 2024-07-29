package com.example.projetSpring.controller;


import com.example.projetSpring.model.Payslip;
import com.example.projetSpring.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payslips")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @GetMapping
    public List<Payslip> getAllPayslips() {
        return payslipService.getAllPayslips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payslip> getPayslipById(@PathVariable Long id) {
        Optional<Payslip> payslip = payslipService.getPayslipById(id);
        return payslip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Payslip createPayslip(@RequestBody Payslip payslip) {
        return payslipService.createPayslip(payslip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payslip> updatePayslip(@PathVariable Long id, @RequestBody Payslip payslipDetails) {
        Payslip updatedPayslip = payslipService.updatePayslip(id, payslipDetails);
        return ResponseEntity.ok(updatedPayslip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayslip(@PathVariable Long id) {
        payslipService.deletePayslip(id);
        return ResponseEntity.noContent().build();
    }
}