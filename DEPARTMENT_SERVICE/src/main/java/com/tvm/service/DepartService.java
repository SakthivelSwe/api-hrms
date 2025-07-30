package com.tvm.service;

import com.tvm.dto.DepartmentHierarchyDTO;
import com.tvm.entity.Department;
import com.tvm.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public Department update(Long id, Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department dept = optionalDepartment.get();
            dept.setName(updatedDepartment.getName());
            dept.setDescription(updatedDepartment.getDescription());
            return departmentRepository.save(dept);
        } else {
            throw new RuntimeException("Department not found with ID: " + id);
        }
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getById(Long id) {
        return departmentRepository.findById(id);
    }
}
