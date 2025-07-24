package com.tvm.repository;

import com.tvm.entity.EmployeeEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntityModel, Long> {

}
