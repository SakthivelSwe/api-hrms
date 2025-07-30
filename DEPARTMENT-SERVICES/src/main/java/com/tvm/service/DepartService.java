package com.tvm.service;

import java.util.List;
import java.util.Optional;

import com.tvm.entity.Department;
import com.tvm.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department create(Department department) {
        return (Department)this.departmentRepository.save(department);
    }

    public Department update(Long id, Department updatedDepartment) {
        Optional<Department> optionalDepartment = this.departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department dept = (Department)optionalDepartment.get();
            dept.setName(updatedDepartment.getName());
            dept.setDescription(updatedDepartment.getDescription());
            return (Department)this.departmentRepository.save(dept);
        } else {
            throw new RuntimeException("Department not found with ID: " + id);
        }
    }

    public void delete(Long id) {
        this.departmentRepository.deleteById(id);
    }

    public List<Department> getAll() {
        return this.departmentRepository.findAll();
    }

    public Optional<Department> getById(Long id) {
        return this.departmentRepository.findById(id);
    }
}
