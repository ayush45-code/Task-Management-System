package com.aiJobResume.Selection.dto.request;

import com.aiJobResume.Selection.enumeration.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
