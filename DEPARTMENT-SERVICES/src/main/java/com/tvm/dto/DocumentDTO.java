package com.tvm.dto;

import java.time.LocalDateTime;

public class DocumentDTO {
    private Long id;
    private Long employeeId;
    private String type;
    private String name;
    private String path;
    private LocalDateTime uploadedAt;

    public Long getId() {
        return this.id;
    }

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public LocalDateTime getUploadedAt() {
        return this.uploadedAt;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setEmployeeId(final Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public void setUploadedAt(final LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DocumentDTO)) {
            return false;
        } else {
            DocumentDTO other = (DocumentDTO)o;
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

                Object this$employeeId = this.getEmployeeId();
                Object other$employeeId = other.getEmployeeId();
                if (this$employeeId == null) {
                    if (other$employeeId != null) {
                        return false;
                    }
                } else if (!this$employeeId.equals(other$employeeId)) {
                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
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

                Object this$path = this.getPath();
                Object other$path = other.getPath();
                if (this$path == null) {
                    if (other$path != null) {
                        return false;
                    }
                } else if (!this$path.equals(other$path)) {
                    return false;
                }

                Object this$uploadedAt = this.getUploadedAt();
                Object other$uploadedAt = other.getUploadedAt();
                if (this$uploadedAt == null) {
                    if (other$uploadedAt != null) {
                        return false;
                    }
                } else if (!this$uploadedAt.equals(other$uploadedAt)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof DocumentDTO;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $employeeId = this.getEmployeeId();
        result = result * 59 + ($employeeId == null ? 43 : $employeeId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $path = this.getPath();
        result = result * 59 + ($path == null ? 43 : $path.hashCode());
        Object $uploadedAt = this.getUploadedAt();
        result = result * 59 + ($uploadedAt == null ? 43 : $uploadedAt.hashCode());
        return result;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "DocumentDTO(id=" + var10000 + ", employeeId=" + this.getEmployeeId() + ", type=" + this.getType() + ", name=" + this.getName() + ", path=" + this.getPath() + ", uploadedAt=" + this.getUploadedAt() + ")";
    }
}
