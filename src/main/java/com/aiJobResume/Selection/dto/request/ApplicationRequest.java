package com.aiJobResume.Selection.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ApplicationRequest {
    private Long userId;
    private Long jobId;
    private Long resumeId;
    private String coverLetter;
}
