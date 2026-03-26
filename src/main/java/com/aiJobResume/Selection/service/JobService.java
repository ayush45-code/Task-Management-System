package com.aiJobResume.Selection.service;

import com.aiJobResume.Selection.dto.request.JobRequest;
import com.aiJobResume.Selection.dto.response.JobResponse;
import com.aiJobResume.Selection.enumeration.JobStatus;

import java.util.List;

public interface JobService {
    JobResponse createJob(JobRequest request);
    JobResponse getJobById(Long id);
    List<JobResponse> getAllJobs();
    List<JobResponse> getJobsByStatus(JobStatus status);
}
