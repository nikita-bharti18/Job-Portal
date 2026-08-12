package com.nikita.jobportal.controller;

import com.nikita.jobportal.dto.JobRequest;
import com.nikita.jobportal.dto.JobResponse;
import com.nikita.jobportal.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<JobResponse> createJob(
            @RequestBody JobRequest request,
            @RequestParam Long companyId) {

        return ResponseEntity.ok(
                jobService.createJob(request, companyId)
        );
    }

    @GetMapping
    public ResponseEntity<List<JobResponse>> getAllJobs() {

        return ResponseEntity.ok(
                jobService.getAllJobs()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponse> getJob(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                jobService.getJobById(id)
        );
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobResponse>> searchJobs(
            @RequestParam String keyword) {

        return ResponseEntity.ok(
                jobService.searchJobs(keyword)
        );
    }

    @GetMapping("/location")
    public ResponseEntity<List<JobResponse>> searchByLocation(
            @RequestParam String location) {

        return ResponseEntity.ok(
                jobService.searchByLocation(location)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobResponse> updateJob(
            @PathVariable Long id,
            @RequestBody JobRequest request) {

        return ResponseEntity.ok(
                jobService.updateJob(id, request)
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
