package com.example.projetSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projetSpring.model.RH;
import com.example.projetSpring.service.RHService;

@RestController
@RequestMapping("/rh")
public class RHController {
    @Autowired
    private RHService rhService;

    @GetMapping("/{id}")
    public RH getRHById(@PathVariable Long id) {
        return rhService.getRHById(id);
    }

    @PostMapping("/approveLeaveRequest/{requestId}")
    public void approveLeaveRequest(@PathVariable Long requestId) {
        rhService.approveLeaveRequest(requestId);
    }

    @PostMapping("/rejectLeaveRequest/{requestId}")
    public void rejectLeaveRequest(@PathVariable Long requestId) {
        rhService.rejectLeaveRequest(requestId);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployeeInfo(@RequestParam Long employeeId, @RequestParam String newAddress, @RequestParam String newPhone) {
        rhService.updateEmployeeInfo(employeeId, newAddress, newPhone);
    }

    @PostMapping("/assignSalary")
    public void assignSalary(@RequestParam Long employeeId, @RequestParam double newSalary) {
        rhService.assignSalary(employeeId, newSalary);
    }

    @PostMapping("/assignBonus")
    public void assignBonus(@RequestParam Long employeeId, @RequestParam double bonus) {
        rhService.assignBonus(employeeId, bonus);
    }
}
