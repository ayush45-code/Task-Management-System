package com.aiJobResume.Selection.repository;

import com.aiJobResume.Selection.entity.JobEntity;
import com.aiJobResume.Selection.enumeration.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Long> {
    List<JobEntity> findByStatus(JobStatus status);
}
