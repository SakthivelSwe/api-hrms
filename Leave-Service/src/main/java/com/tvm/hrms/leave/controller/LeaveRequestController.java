package com.tvm.hrms.leave.controller;

import com.tvm.hrms.leave.dto.LeaveApprovalDto;
import com.tvm.hrms.leave.dto.LeaveRequestDto;
import com.tvm.hrms.leave.model_1.LeaveRequest;
import com.tvm.hrms.leave.service.LeaveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaveRequestController {

    private final LeaveService leaveService;

    public LeaveRequestController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/leaves")
    public LeaveRequest applyLeave(@RequestBody LeaveRequestDto dto) {
        return leaveService.applyLeave(dto);
    }

    @PutMapping("/{id}/approve")
    public String approveLeave(@PathVariable Long id, @RequestParam boolean approved) {
        return leaveService.approveLeave(id, approved);
    }




    @GetMapping("/all")
    public List<LeaveRequest> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/id/{id}")
    public LeaveRequest getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }
}
