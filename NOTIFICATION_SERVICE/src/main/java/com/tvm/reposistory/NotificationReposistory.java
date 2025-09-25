package com.tvm.reposistory;
import com.tvm.model.NotificationModel;
import org.springframework.data.jpa.repository.JpaRepository;

//logs
public interface NotificationReposistory extends JpaRepository<NotificationModel, Long> {

}

