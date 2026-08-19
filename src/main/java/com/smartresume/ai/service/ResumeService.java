package com.smartresume.ai.service;

import com.smartresume.ai.entity.Resume;

import java.util.List;

public interface ResumeService {

    Resume createResume(Resume resume);

    Resume getResumeById(Long id);

    List<Resume> getAllResumes();

    Resume updateResume(Long id, Resume resume);

    void deleteResume(Long id);

    double calculateAtsScore(Long id);
}