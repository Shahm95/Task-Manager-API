package com.security.task_manager_api.repository;

import com.security.task_manager_api.model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);
    UserEntity findByIdAndDeletedAtNull(Integer id);
    boolean existsByUsername(String username);


}
