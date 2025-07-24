package com.tvm.repository;
import com.tvm.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface DocumentRepository extends JpaRepository<Document, Long>{
    List<Document> findByEmployeeId(Long employeeId);
}
