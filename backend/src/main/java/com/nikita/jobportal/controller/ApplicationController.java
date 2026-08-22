package com.nikita.jobportal.controller;

import com.nikita.jobportal.dto.ApplicationResponse;
import com.nikita.jobportal.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    // Apply for Job

    @PostMapping
    public ResponseEntity<ApplicationResponse> apply(
            @RequestParam Long userId,
            @RequestParam Long jobId) {

        return ResponseEntity.ok(
                applicationService.applyForJob(
                        userId,
                        jobId
                )
        );
    }

    // User Applications

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationResponse>>
    getUserApplications(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                applicationService
                        .getUserApplications(userId)
        );
    }

    // Job Applicants

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponse>>
    getJobApplications(
            @PathVariable Long jobId) {

        return ResponseEntity.ok(
                applicationService
                        .getJobApplications(jobId)
        );
    }

    // Update Application Status

    @PutMapping("/{applicationId}/status")
    public ResponseEntity<ApplicationResponse>
    updateStatus(
            @PathVariable Long applicationId,
            @RequestParam String status) {

        return ResponseEntity.ok(
                applicationService.updateStatus(
                        applicationId,
                        status
                )
        );
    }
}
