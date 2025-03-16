package com.security.task_manager_api.service;

import com.security.task_manager_api.model.DTO.RegisterRequest;
import com.security.task_manager_api.model.Entity.Role;
import com.security.task_manager_api.model.Entity.UserEntity;
import com.security.task_manager_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void register(RegisterRequest registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(Role.USER); // Default role
        userRepository.save(user);
    }



}
