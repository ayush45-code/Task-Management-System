package com.aiJobResume.Selection.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
@Getter
@Setter
public class ResumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;

    @Column(length = 2000)
    private String extractedSkills;

    @CreationTimestamp
    private LocalDateTime uploadDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}