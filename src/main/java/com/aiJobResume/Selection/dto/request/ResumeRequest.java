package com.aiJobResume.Selection.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResumeRequest {
    private Long userId;
    private String filePath;
    private String extractedSkills;
}
