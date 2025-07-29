package com.tvm.controller;


import com.tvm.dto.EmployeeRequestDto;
import com.tvm.dto.EmployeeResponseDto;
import com.tvm.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        List<EmployeeResponseDto> employees = employeeServices.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeResponseDto> employee = employeeServices.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.status(404).body(
                    Map.of("Error", "Employee with ID " + id + " not found in database.")
            );
        }
    }

    @PostMapping("/register")
    public ResponseEntity<EmployeeResponseDto> registerEmployee(@RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto savedEmp = employeeServices.registerEmployee(dto);
        return ResponseEntity.ok(savedEmp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDto dto) {
        EmployeeResponseDto updated = employeeServices.updateEmployee(id, dto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(404).body(
                    Map.of("error", "Employee with ID " + id + " not found.")
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Optional<EmployeeResponseDto> employee = employeeServices.findById(id);
        if (employee.isPresent()) {
            employeeServices.deleteEmployee(id);
            return ResponseEntity.ok(Map.of("Message", "Employee deleted successfully."));
        } else {
            return ResponseEntity.status(404).body(Map.of("Error", "Employee not found in database."));
        }
    }
}
