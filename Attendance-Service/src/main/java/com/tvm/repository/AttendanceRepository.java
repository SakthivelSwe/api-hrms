package com.tvm.repository;

import com.tvm.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByEmployeeIdAndDate(Long employeeId, LocalDate date);

    List<Attendance> findAllByEmployeeId(Long employeeId);

    List<Attendance> findAllByDate(LocalDate date);

    List<Attendance> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate start, LocalDate end);

    List<Attendance> findByDateBetween(LocalDate start, LocalDate end);


}
