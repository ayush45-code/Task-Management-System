package com.aiJobResume.Selection.entity;

import com.aiJobResume.Selection.enumeration.JobStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String company;

    private String skillsRequired;

    private String location;

    private String salaryRange;

    private Integer experienceRequired;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "job")
//    @JsonIgnore
    private List<ApplicationEntity> applications;
}