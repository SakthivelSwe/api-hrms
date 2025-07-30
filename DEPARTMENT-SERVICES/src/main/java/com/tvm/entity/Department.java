package com.tvm.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "departments"
)
public class Department {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String name;
    private String description;
    private Long reportingManagerId;
    @ElementCollection
    @CollectionTable(
            name = "department_employees",
            joinColumns = {@JoinColumn(
                    name = "department_id"
            )}
    )
    @Column(
            name = "employee_id"
    )
    private List<Long> employeeIds = new ArrayList();
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "parent_id"
    )
    @JsonBackReference
    private Department parent;
    @OneToMany(
            mappedBy = "parent",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Department> children = new ArrayList();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReportingManagerId() {
        return this.reportingManagerId;
    }

    public void setReportingManagerId(Long reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }

    public List<Long> getEmployeeIds() {
        return this.employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public Department getParent() {
        return this.parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public List<Department> getChildren() {
        return this.children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    public Department() {
    }

    public Department(final Long id, final String name, final String description, final Long reportingManagerId, final List<Long> employeeIds, final Department parent, final List<Department> children) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reportingManagerId = reportingManagerId;
        this.employeeIds = employeeIds;
        this.parent = parent;
        this.children = children;
    }
}
