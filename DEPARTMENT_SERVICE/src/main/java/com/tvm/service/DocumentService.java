package com.tvm.service;

import com.tvm.entity.Document;
import com.tvm.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    private final String uploadDir = "uploads"; // can be externalized

    @Transactional
    public Document saveDocument(Long employeeId, String type, MultipartFile file) throws IOException {
        // Create directory if not present
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        // Avoid file name conflict
        String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = uploadDir + File.separator + uniqueFileName;

        // Save file to disk
        file.transferTo(new File(filePath));

        // Save metadata to DB
        Document document = new Document();
        document.setEmployeeId(employeeId);
        document.setType(type);
        document.setName(uniqueFileName);
        document.setPath(filePath);
        document.setUploadedAt(LocalDateTime.now());

        return documentRepository.save(document);
    }
}

