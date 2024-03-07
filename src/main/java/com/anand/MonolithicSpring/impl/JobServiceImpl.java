package com.anand.MonolithicSpring.impl;

import com.anand.MonolithicSpring.model.Job;
import com.anand.MonolithicSpring.repository.JobRepository;
import com.anand.MonolithicSpring.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job searcById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateById(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                if (updatedJob.getDescription() != null) {
                    job.setDescription(updatedJob.getDescription());
                }
                if (updatedJob.getLocation() != null) {
                    job.setLocation(updatedJob.getLocation());
                }
                if (updatedJob.getTitle() != null) {
                    job.setTitle(updatedJob.getTitle());
                }
                if (updatedJob.getMinSalary() != null) {
                    job.setMinSalary(updatedJob.getMinSalary());
                }
                if (updatedJob.getMaxSalary() != null) {
                    job.setMaxSalary(updatedJob.getMaxSalary());
                }
                jobRepository.save(job);
                return true;
            }

        return false;
    }
}
