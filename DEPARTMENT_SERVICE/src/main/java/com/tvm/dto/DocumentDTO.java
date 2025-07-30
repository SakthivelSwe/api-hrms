package com.tvm.dto;
import lombok.Data;
import java.time.LocalDateTime;

@Data

public class DocumentDTO {
    private Long id;
    private Long employeeId;
    private String type;
    private String name;
    private String path;
    private LocalDateTime uploadedAt;
}
