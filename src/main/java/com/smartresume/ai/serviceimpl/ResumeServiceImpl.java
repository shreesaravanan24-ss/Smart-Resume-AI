package com.smartresume.ai.serviceimpl;

import com.smartresume.ai.entity.Resume;
import com.smartresume.ai.exception.ResumeNotFoundException;
import com.smartresume.ai.repository.ResumeRepository;
import com.smartresume.ai.service.ResumeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public Resume createResume(Resume resume) {

        double score = calculateScore(resume);

        resume.setAtsScore(score);

        return resumeRepository.save(resume);
    }

    @Override
    public Resume getResumeById(Long id) {

        return resumeRepository.findById(id)
                .orElseThrow(() ->
                        new ResumeNotFoundException(
                                "Resume not found with ID: " + id
                        ));
    }

    @Override
    public List<Resume> getAllResumes() {

        return resumeRepository.findAll();
    }

    @Override
    public Resume updateResume(Long id, Resume resume) {

        Resume existing = getResumeById(id);

        existing.setName(resume.getName());
        existing.setEmail(resume.getEmail());
        existing.setPhone(resume.getPhone());
        existing.setSkills(resume.getSkills());
        existing.setEducation(resume.getEducation());
        existing.setExperience(resume.getExperience());
        existing.setProjects(resume.getProjects());

        existing.setAtsScore(calculateScore(existing));

        return resumeRepository.save(existing);
    }

    @Override
    public void deleteResume(Long id) {

        Resume existing = getResumeById(id);

        resumeRepository.delete(existing);
    }

    @Override
    public double calculateAtsScore(Long id) {

        Resume resume = getResumeById(id);

        double score = calculateScore(resume);

        resume.setAtsScore(score);

        resumeRepository.save(resume);

        return score;
    }

    private double calculateScore(Resume resume) {

        double score = 0;

        if (resume.getName() != null && !resume.getName().isBlank())
            score += 10;

        if (resume.getEmail() != null && !resume.getEmail().isBlank())
            score += 10;

        if (resume.getPhone() != null && !resume.getPhone().isBlank())
            score += 10;

        if (resume.getSkills() != null && !resume.getSkills().isBlank())
            score += 20;

        if (resume.getEducation() != null && !resume.getEducation().isBlank())
            score += 15;

        if (resume.getExperience() != null && !resume.getExperience().isBlank())
            score += 20;

        if (resume.getProjects() != null && !resume.getProjects().isBlank())
            score += 15;

        return score;
    }
}