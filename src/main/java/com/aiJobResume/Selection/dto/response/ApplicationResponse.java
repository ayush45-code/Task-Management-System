package com.aiJobResume.Selection.dto.response;

import com.aiJobResume.Selection.enumeration.ApplicationStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ApplicationResponse {
    private Long id;
    private Long userId;
    private Long jobId;
    private Long resumeId;
    private ApplicationStatus status;
    private Double matchScore;
    private String coverLetter;
    private String recruiterNotes;
    private LocalDateTime appliedDate;
}
