package com.tvm.controller;

import java.util.List;

import com.tvm.entity.Department;
import com.tvm.service.DepartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping({"/departments"})
public class DepartmentController {
    private final DepartService service;

    public DepartmentController(DepartService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(this.service.create(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Department> getById(@PathVariable Long id) {
        return (ResponseEntity)this.service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
        return ResponseEntity.ok(this.service.update(id, department));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
