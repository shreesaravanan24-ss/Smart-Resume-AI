package com.smartresume.ai.serviceimpl;

import com.smartresume.ai.entity.Job;
import com.smartresume.ai.repository.JobRepository;
import com.smartresume.ai.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job createJob(Job job) {

        return jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Job not found with ID: " + id
                        ));
    }

    @Override
    public List<Job> getAllJobs() {

        return jobRepository.findAll();
    }

    @Override
    public Job updateJob(Long id, Job job) {

        Job existing = getJobById(id);

        existing.setTitle(job.getTitle());
        existing.setCompany(job.getCompany());
        existing.setRequiredSkills(job.getRequiredSkills());
        existing.setDescription(job.getDescription());

        return jobRepository.save(existing);
    }

    @Override
    public void deleteJob(Long id) {

        Job existing = getJobById(id);

        jobRepository.delete(existing);
    }
}