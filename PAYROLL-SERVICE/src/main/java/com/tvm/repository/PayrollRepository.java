package com.tvm.repository;

import com.tvm.entity.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    Optional<Payroll> findByEmployeeIdAndMonthAndYear(Long employeeId, int month, int year);

    boolean existsByEmployeeIdAndMonthAndYear(Long employeeId, int month, int year);
}
