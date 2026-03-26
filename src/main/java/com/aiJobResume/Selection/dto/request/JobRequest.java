package com.aiJobResume.Selection.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class JobRequest {
    private String title;
    private String description;
    private String company;
    private String skillsRequired;
    private String location;
    private String salaryRange;
    private Integer experienceRequired;
}
