package com.aiJobResume.Selection.service;

import com.aiJobResume.Selection.dto.request.UserRegistrationRequest;
import com.aiJobResume.Selection.dto.response.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRegistrationRequest request);
    UserResponse getUserById(Long id);
    UserResponse getUserByEmail(String email);
}
