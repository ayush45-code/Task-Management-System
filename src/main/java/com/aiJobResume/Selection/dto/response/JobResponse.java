package com.aiJobResume.Selection.dto.response;

import com.aiJobResume.Selection.enumeration.JobStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class JobResponse {
    private Long id;
    private String title;
    private String description;
    private String company;
    private String skillsRequired;
    private String location;
    private String salaryRange;
    private Integer experienceRequired;
    private JobStatus status;
    private LocalDateTime createdAt;
}
