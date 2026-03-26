package com.aiJobResume.Selection.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ResumeResponse {
    private Long id;
    private Long userId;
    private String filePath;
    private String extractedSkills;
    private LocalDateTime uploadDate;
}
