package com.aiJobResume.Selection.serviceImpl;

import com.aiJobResume.Selection.dto.request.ResumeRequest;
import com.aiJobResume.Selection.dto.response.ResumeResponse;
import com.aiJobResume.Selection.entity.ResumeEntity;
import com.aiJobResume.Selection.entity.UserEntity;
import com.aiJobResume.Selection.exception.ResourceNotFoundException;
import com.aiJobResume.Selection.repository.ResumeRepository;
import com.aiJobResume.Selection.repository.UserRepository;
import com.aiJobResume.Selection.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    @Override
    public ResumeResponse uploadResume(ResumeRequest request) {
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        ResumeEntity resume = new ResumeEntity();
        resume.setUser(user);
        resume.setFilePath(request.getFilePath());
        resume.setExtractedSkills(request.getExtractedSkills());

        ResumeEntity savedResume = resumeRepository.save(resume);
        return mapToResponse(savedResume);
    }

    @Override
    public ResumeResponse getResumeById(Long id) {
        ResumeEntity resume = resumeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resume not found with id: " + id));
        return mapToResponse(resume);
    }

    @Override
    public List<ResumeResponse> getResumesByUserId(Long userId) {
        return resumeRepository.findByUserId(userId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteResume(Long id) {
        ResumeEntity resume = resumeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resume not found with id: " + id));
        resumeRepository.delete(resume);
    }

    private ResumeResponse mapToResponse(ResumeEntity resume) {
        ResumeResponse response = new ResumeResponse();
        response.setId(resume.getId());
        response.setUserId(resume.getUser().getId());
        response.setFilePath(resume.getFilePath());
        response.setExtractedSkills(resume.getExtractedSkills());
        response.setUploadDate(resume.getUploadDate());
        return response;
    }
}
