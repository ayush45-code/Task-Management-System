package com.aiJobResume.Selection.serviceImpl;

import com.aiJobResume.Selection.dto.request.JobRequest;
import com.aiJobResume.Selection.dto.response.JobResponse;
import com.aiJobResume.Selection.entity.JobEntity;
import com.aiJobResume.Selection.enumeration.JobStatus;
import com.aiJobResume.Selection.exception.ResourceNotFoundException;
import com.aiJobResume.Selection.repository.JobRepository;
import com.aiJobResume.Selection.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public JobResponse createJob(JobRequest request) {
        JobEntity job = new JobEntity();
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setCompany(request.getCompany());
        job.setSkillsRequired(request.getSkillsRequired());
        job.setLocation(request.getLocation());
        job.setSalaryRange(request.getSalaryRange());
        job.setExperienceRequired(request.getExperienceRequired());
        job.setStatus(JobStatus.OPEN);

        JobEntity savedJob = jobRepository.save(job);
        return mapToResponse(savedJob);
    }

    @Override
    public JobResponse getJobById(Long id) {
        JobEntity job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
        return mapToResponse(job);
    }

    @Override
    public List<JobResponse> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobResponse> getJobsByStatus(JobStatus status) {
        return jobRepository.findByStatus(status).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private JobResponse mapToResponse(JobEntity job) {
        JobResponse response = new JobResponse();
        response.setId(job.getId());
        response.setTitle(job.getTitle());
        response.setDescription(job.getDescription());
        response.setCompany(job.getCompany());
        response.setSkillsRequired(job.getSkillsRequired());
        response.setLocation(job.getLocation());
        response.setSalaryRange(job.getSalaryRange());
        response.setExperienceRequired(job.getExperienceRequired());
        response.setStatus(job.getStatus());
        response.setCreatedAt(job.getCreatedAt());
        return response;
    }
}
