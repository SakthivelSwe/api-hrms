package com.tvm.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import com.tvm.entity.Document;
import com.tvm.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    private final String uploadDir = "uploads";

    @Transactional
    public Document saveDocument(Long employeeId, String type, MultipartFile file) throws IOException {
        File dir = new File("uploads");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        long var10000 = System.currentTimeMillis();
        String uniqueFileName = var10000 + "_" + file.getOriginalFilename();
        String filePath = "uploads" + File.separator + uniqueFileName;
        file.transferTo(new File(filePath));
        Document document = new Document();
        document.setEmployeeId(employeeId);
        document.setType(type);
        document.setName(uniqueFileName);
        document.setPath(filePath);
        document.setUploadedAt(LocalDateTime.now());
        return (Document)this.documentRepository.save(document);
    }
}
