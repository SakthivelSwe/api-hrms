package com.tvm.reposistory;


import com.tvm.model.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NotificationTemplateRepo extends JpaRepository<NotificationTemplate, Long> {
    Optional<NotificationTemplate> findByType(String type);
}
