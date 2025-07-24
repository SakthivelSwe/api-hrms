package com.tvm.hrms.leave.controller;


import com.tvm.hrms.leave.Repository.LeaveBalanceRepository;
import com.tvm.hrms.leave.model_1.LeaveBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeaveBalanceController {

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    @GetMapping
    public List<LeaveBalance> getAllBalances() {
        return leaveBalanceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveBalance> getBalanceById(@PathVariable Long id) {
        return leaveBalanceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping ("/leave-balances")
    public ResponseEntity<LeaveBalance> createLeaveBalance(@RequestBody LeaveBalance balance) {
        return ResponseEntity.ok(leaveBalanceRepository.save(balance));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveBalance> updateBalance(@PathVariable Long id, @RequestBody LeaveBalance updated) {
        return leaveBalanceRepository.findById(id)
                .map(existing -> {
                    existing.setCasualLeave(updated.getCasualLeave());
                    existing.setEarnedLeave(updated.getEarnedLeave());
                    existing.setSickLeave(updated.getSickLeave());
                    return ResponseEntity.ok(leaveBalanceRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBalance(@PathVariable Long id) {
        if (!leaveBalanceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        leaveBalanceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
