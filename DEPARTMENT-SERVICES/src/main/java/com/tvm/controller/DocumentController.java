package com.tvm.controller;



import com.tvm.entity.Document;
import com.tvm.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping({"/api/documents"})
@Tag(
        name = "Document Management",
        description = "Upload and download employee documents"
)
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Operation(
            summary = "Upload document for employee"
    )
    @PostMapping({"/upload"})
    public ResponseEntity<String> uploadDocument(@RequestParam("employeeId") Long employeeId, @RequestParam("type") String type, @RequestParam("file") MultipartFile file) {
        try {
            Document saved = this.documentService.saveDocument(employeeId, type, file);
            return ResponseEntity.ok("Uploaded successfully: " + saved.getName());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + e.getMessage());
        }
    }

    @Operation(
            summary = "Download document by file name"
    )
    @GetMapping({"/download/{filename}"})
    public ResponseEntity<byte[]> downloadDocument(@PathVariable String filename) {
        try {
            File file = new File("uploads" + File.separator + filename);
            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body((byte[]) null);
            } else {
                byte[] content = Files.readAllBytes(file.toPath());
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename).build());
                return new ResponseEntity(content, headers, HttpStatus.OK);
            }
        } catch (IOException var5) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((byte[]) null);
        }
    }
}
