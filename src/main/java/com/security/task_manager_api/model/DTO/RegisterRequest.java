package com.security.task_manager_api.model.DTO;

import com.security.task_manager_api.model.Entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private Role role;
}
