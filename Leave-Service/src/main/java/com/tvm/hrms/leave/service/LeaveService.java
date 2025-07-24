package com.tvm.hrms.leave.service;

import com.tvm.hrms.leave.dto.LeaveApprovalDto;
import com.tvm.hrms.leave.dto.LeaveRequestDto;
import com.tvm.hrms.leave.model_1.LeaveRequest;

import java.util.List;

public interface LeaveService {
    LeaveRequest applyLeave(LeaveRequestDto dto);
    boolean approveLeave(Long id, LeaveApprovalDto dto);

    String approveLeave(Long id, boolean approved);

    List<LeaveRequest> getAllLeaves();
    LeaveRequest getLeaveById(Long id);
}
