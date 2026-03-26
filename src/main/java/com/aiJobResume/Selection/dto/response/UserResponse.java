package com.aiJobResume.Selection.dto.response;

import com.aiJobResume.Selection.enumeration.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
}
