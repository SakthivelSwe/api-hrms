package com.tvm.dto;


import java.util.List;

public class DepartmentHierarchyDTO {
    private Long id;
    private String name;
    private String description;
    private Long reportingManagerId;
    private List<DepartmentHierarchyDTO> subDepartments;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Long getReportingManagerId() {
        return this.reportingManagerId;
    }

    public List<DepartmentHierarchyDTO> getSubDepartments() {
        return this.subDepartments;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setReportingManagerId(final Long reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }

    public void setSubDepartments(final List<DepartmentHierarchyDTO> subDepartments) {
        this.subDepartments = subDepartments;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DepartmentHierarchyDTO)) {
            return false;
        } else {
            DepartmentHierarchyDTO other = (DepartmentHierarchyDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$reportingManagerId = this.getReportingManagerId();
                Object other$reportingManagerId = other.getReportingManagerId();
                if (this$reportingManagerId == null) {
                    if (other$reportingManagerId != null) {
                        return false;
                    }
                } else if (!this$reportingManagerId.equals(other$reportingManagerId)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$description = this.getDescription();
                Object other$description = other.getDescription();
                if (this$description == null) {
                    if (other$description != null) {
                        return false;
                    }
                } else if (!this$description.equals(other$description)) {
                    return false;
                }

                Object this$subDepartments = this.getSubDepartments();
                Object other$subDepartments = other.getSubDepartments();
                if (this$subDepartments == null) {
                    if (other$subDepartments != null) {
                        return false;
                    }
                } else if (!this$subDepartments.equals(other$subDepartments)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DepartmentHierarchyDTO;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $reportingManagerId = this.getReportingManagerId();
        result = result * 59 + ($reportingManagerId == null ? 43 : $reportingManagerId.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $description = this.getDescription();
        result = result * 59 + ($description == null ? 43 : $description.hashCode());
        Object $subDepartments = this.getSubDepartments();
        result = result * 59 + ($subDepartments == null ? 43 : $subDepartments.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "DepartmentHierarchyDTO(id=" + var10000 + ", name=" + this.getName() + ", description=" + this.getDescription() + ", reportingManagerId=" + this.getReportingManagerId() + ", subDepartments=" + this.getSubDepartments() + ")";
    }
}
