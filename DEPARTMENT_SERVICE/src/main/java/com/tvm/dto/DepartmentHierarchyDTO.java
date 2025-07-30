package com.tvm.dto;
import com.tvm.entity.Department;
import lombok.Data;

import java.security.PrivateKey;
import java.util.List;
@Data
public class DepartmentHierarchyDTO {
    private Long id;
    private String name;
    private String description;
    private Long reportingManagerId;
    private List<DepartmentHierarchyDTO> subDepartments;

}
