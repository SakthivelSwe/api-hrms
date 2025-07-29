package com.tvm.repository;

import com.tvm.model.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
    Optional<NotificationModel> findByType(String type);
}
