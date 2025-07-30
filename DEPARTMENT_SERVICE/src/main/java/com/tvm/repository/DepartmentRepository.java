package com.tvm.repository;

import com.tvm.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByParentIsNull(); // For hierarchy fetching
}
