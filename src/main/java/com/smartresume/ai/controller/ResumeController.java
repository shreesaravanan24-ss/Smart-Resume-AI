package com.smartresume.ai.controller;

import com.smartresume.ai.entity.Resume;
import com.smartresume.ai.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public ResponseEntity<Resume> createResume(
            @RequestBody Resume resume) {

        return ResponseEntity.ok(
                resumeService.createResume(resume)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResume(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                resumeService.getResumeById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {

        return ResponseEntity.ok(
                resumeService.getAllResumes()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(
            @PathVariable Long id,
            @RequestBody Resume resume) {

        return ResponseEntity.ok(
                resumeService.updateResume(id, resume)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResume(
            @PathVariable Long id) {

        resumeService.deleteResume(id);

        return ResponseEntity.ok(
                "Resume deleted successfully"
        );
    }

    @GetMapping("/{id}/ats-score")
    public ResponseEntity<Double> getAtsScore(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                resumeService.calculateAtsScore(id)
        );
    }
}