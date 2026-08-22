package com.nikita.jobportal.controller;

import com.nikita.jobportal.entity.Resume;
import com.nikita.jobportal.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(
            ResumeService resumeService) {

        this.resumeService = resumeService;
    }

    @PostMapping
    public ResponseEntity<Resume> saveResume(
            @RequestParam Long userId,
            @RequestParam String fileName,
            @RequestParam String fileUrl) {

        return ResponseEntity.ok(
                resumeService.saveResume(
                        userId,
                        fileName,
                        fileUrl
                )
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Resume> getResume(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                resumeService.getResume(userId)
        );
    }
}
