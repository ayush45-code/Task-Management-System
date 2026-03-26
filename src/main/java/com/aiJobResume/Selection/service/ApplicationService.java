package com.aiJobResume.Selection.service;

import com.aiJobResume.Selection.dto.request.ApplicationRequest;
import com.aiJobResume.Selection.dto.response.ApplicationResponse;
import com.aiJobResume.Selection.enumeration.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
    ApplicationResponse submitApplication(ApplicationRequest request);
    ApplicationResponse getApplicationById(Long id);
    List<ApplicationResponse> getApplicationsByUserId(Long userId);
    List<ApplicationResponse> getApplicationsByJobId(Long jobId);
    ApplicationResponse updateApplicationStatus(Long id, ApplicationStatus status);
}
