package com.example.projetSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.projetSpring.model.LeaveRequest;
import com.example.projetSpring.service.LeaveRequestService;

import java.util.List;

@RestController
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/add")
    public LeaveRequest addLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.addLeaveRequest(leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.getLeaveRequestById(id);
    }

    @PutMapping("/update")
    public LeaveRequest updateLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.updateLeaveRequest(leaveRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
    }
}