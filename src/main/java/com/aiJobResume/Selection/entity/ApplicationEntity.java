package com.aiJobResume.Selection.entity;

import com.aiJobResume.Selection.enumeration.ApplicationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@Getter
@Setter
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobEntity job;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private ResumeEntity resume;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private Double matchScore;

    private String coverLetter;

    private String recruiterNotes;

    @CreationTimestamp
    private LocalDateTime appliedDate;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}