package com.tvm.hrms.leave.service;

import com.tvm.hrms.leave.Exception.LeaveNotFoundException;
import com.tvm.hrms.leave.Repository.LeaveBalanceRepository;
import com.tvm.hrms.leave.Repository.LeaveRequestRepository;
import com.tvm.hrms.leave.dto.LeaveApprovalDto;
import com.tvm.hrms.leave.dto.LeaveRequestDto;
import com.tvm.hrms.leave.model_1.LeaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRequestRepository leaveRequestRepo;
    private final LeaveBalanceRepository leaveBalanceRepo;

    public LeaveServiceImpl(LeaveRequestRepository leaveRequestRepo, LeaveBalanceRepository leaveBalanceRepo) {
        this.leaveRequestRepo = leaveRequestRepo;
        this.leaveBalanceRepo = leaveBalanceRepo;
    }

    @Override
    public LeaveRequest applyLeave(LeaveRequestDto dto) {
        LeaveRequest leave = new LeaveRequest();
        leave.setEmployeeId(dto.getEmployeeId());
        leave.setFromDate(dto.getFromDate());
        leave.setToDate(dto.getToDate());
        leave.setLeaveType(dto.getLeaveType());
        leave.setReason(dto.getReason());
        leave.setStatus("PENDING");
        return leaveRequestRepo.save(leave);
    }


    @Override
    public boolean approveLeave(Long id, LeaveApprovalDto dto) {
        String status = dto.isApproved() ? "APPROVED" : "REJECTED";
        LeaveRequest leave = leaveRequestRepo.findById(id)
                .orElseThrow(() -> new LeaveNotFoundException("Leave not found"));
        leave.setStatus(status);
        leaveRequestRepo.save(leave);
        return dto.isApproved();
    }

    @Override
    public String approveLeave(Long id, boolean approved) {
        LeaveRequest leave = leaveRequestRepo.findById(id)
                .orElseThrow(() -> new LeaveNotFoundException("Leave not found"));

        String status = approved ? "APPROVED" : "REJECTED";
        leave.setStatus(status);
        leaveRequestRepo.save(leave);

        return approved ? "Approved" : "Rejected";
    }

    @Override
    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepo.findAll();
    }

    @Override
    public LeaveRequest getLeaveById(Long id) {
        return leaveRequestRepo.findById(id)
                .orElseThrow(() -> new LeaveNotFoundException("Leave not found"));
    }
}
