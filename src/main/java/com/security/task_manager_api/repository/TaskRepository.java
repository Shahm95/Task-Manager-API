package com.security.task_manager_api.repository;

import com.security.task_manager_api.model.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    TaskEntity findByIdAndDeletedAtNull(Integer id);
    List<TaskEntity> findByDeletedAtIsNull();





}
