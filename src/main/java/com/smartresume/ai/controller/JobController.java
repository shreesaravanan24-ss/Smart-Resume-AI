package com.smartresume.ai.controller;

import com.smartresume.ai.entity.Job;
import com.smartresume.ai.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Job> createJob(
            @RequestBody Job job) {

        return ResponseEntity.ok(
                jobService.createJob(job)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                jobService.getJobById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {

        return ResponseEntity.ok(
                jobService.getAllJobs()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(
            @PathVariable Long id,
            @RequestBody Job job) {

        return ResponseEntity.ok(
                jobService.updateJob(id, job)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(
            @PathVariable Long id) {

        jobService.deleteJob(id);

        return ResponseEntity.ok(
                "Job deleted successfully"
        );
    }
}