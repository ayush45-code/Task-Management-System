package com.aiJobResume.Selection.service;

import com.aiJobResume.Selection.dto.request.ResumeRequest;
import com.aiJobResume.Selection.dto.response.ResumeResponse;

import java.util.List;

public interface ResumeService {
    ResumeResponse uploadResume(ResumeRequest request);
    ResumeResponse getResumeById(Long id);
    List<ResumeResponse> getResumesByUserId(Long userId);
    void deleteResume(Long id);
}
