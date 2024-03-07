package com.anand.MonolithicSpring.service;

import com.anand.MonolithicSpring.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job searcById(Long id);

    Boolean deleteById(Long id);

    boolean updateById(Long id, Job job);
}
