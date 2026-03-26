package com.aiJobResume.Selection.serviceImpl;

import com.aiJobResume.Selection.dto.request.ApplicationRequest;
import com.aiJobResume.Selection.dto.response.ApplicationResponse;
import com.aiJobResume.Selection.entity.ApplicationEntity;
import com.aiJobResume.Selection.entity.JobEntity;
import com.aiJobResume.Selection.entity.ResumeEntity;
import com.aiJobResume.Selection.entity.UserEntity;
import com.aiJobResume.Selection.enumeration.ApplicationStatus;
import com.aiJobResume.Selection.exception.ResourceNotFoundException;
import com.aiJobResume.Selection.repository.ApplicationRepository;
import com.aiJobResume.Selection.repository.JobRepository;
import com.aiJobResume.Selection.repository.ResumeRepository;
import com.aiJobResume.Selection.repository.UserRepository;
import com.aiJobResume.Selection.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private final ResumeRepository resumeRepository;

    @Override
    public ApplicationResponse submitApplication(ApplicationRequest request) {
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));
        JobEntity job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + request.getJobId()));
        ResumeEntity resume = resumeRepository.findById(request.getResumeId())
                .orElseThrow(() -> new ResourceNotFoundException("Resume not found with id: " + request.getResumeId()));

        ApplicationEntity application = new ApplicationEntity();
        application.setUser(user);
        application.setJob(job);
        application.setResume(resume);
        application.setCoverLetter(request.getCoverLetter());
        application.setStatus(ApplicationStatus.APPLIED);
        application.setMatchScore(0.0); // Initially 0, gets updated by AI service

        ApplicationEntity savedApplication = applicationRepository.save(application);
        return mapToResponse(savedApplication);
    }

    @Override
    public ApplicationResponse getApplicationById(Long id) {
        ApplicationEntity application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
        return mapToResponse(application);
    }

    @Override
    public List<ApplicationResponse> getApplicationsByUserId(Long userId) {
        return applicationRepository.findByUserId(userId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationResponse> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationResponse updateApplicationStatus(Long id, ApplicationStatus status) {
        ApplicationEntity application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: " + id));
        
        application.setStatus(status);
        ApplicationEntity updatedApplication = applicationRepository.save(application);
        return mapToResponse(updatedApplication);
    }

    private ApplicationResponse mapToResponse(ApplicationEntity application) {
        ApplicationResponse response = new ApplicationResponse();
        response.setId(application.getId());
        response.setUserId(application.getUser().getId());
        response.setJobId(application.getJob().getId());
        response.setResumeId(application.getResume().getId());
        response.setStatus(application.getStatus());
        response.setMatchScore(application.getMatchScore());
        response.setCoverLetter(application.getCoverLetter());
        response.setRecruiterNotes(application.getRecruiterNotes());
        response.setAppliedDate(application.getAppliedDate());
        return response;
    }
}
