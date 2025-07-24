package com.tvm.service;

import com.tvm.dto.EmployeeRequestDto;
import com.tvm.dto.EmployeeResponseDto;
import com.tvm.entity.EmployeeEntityModel;
import com.tvm.model.EmployeeStatus;
import com.tvm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

       public EmployeeResponseDto registerEmployee(EmployeeRequestDto dto) {
        EmployeeEntityModel employee = new EmployeeEntityModel();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDesignation(dto.getDesignation());


        employee.setStatus(dto.getStatus() != null
                ? EmployeeStatus.valueOf(dto.getStatus().toUpperCase())
                : EmployeeStatus.PENDING);

        EmployeeEntityModel saved = employeeRepository.save(employee);
        return convertToDto(saved);
    }


    public Optional<EmployeeResponseDto> findById(Long id) {
        return employeeRepository.findById(id)
                .map(this::convertToDto);
    }

        public List<EmployeeResponseDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }


    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto dto) {
        Optional<EmployeeEntityModel> optionalEmp = employeeRepository.findById(id);
        if (optionalEmp.isPresent()) {
            EmployeeEntityModel emp = optionalEmp.get();
            emp.setName(dto.getName());
            emp.setEmail(dto.getEmail());
            emp.setDesignation(dto.getDesignation());

            if (dto.getStatus() != null) {
                emp.setStatus(EmployeeStatus.valueOf(dto.getStatus().toUpperCase()));
            }

            EmployeeEntityModel updated = employeeRepository.save(emp);
            return convertToDto(updated);
        }
        return null;
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    private EmployeeResponseDto convertToDto(EmployeeEntityModel emp) {
        return new EmployeeResponseDto(
                emp.getId(),
                emp.getName(),
                emp.getEmail(),
                emp.getDesignation(),
                emp.getStatus().toString()
        );
    }
}
