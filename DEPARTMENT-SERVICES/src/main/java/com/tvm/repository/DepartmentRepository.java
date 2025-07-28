package com.tvm.repository;

import java.util.List;

import com.tvm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByParentIsNull();
}
