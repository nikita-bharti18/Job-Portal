package com.nikita.jobportal.controller;

import com.nikita.jobportal.entity.SavedJob;
import com.nikita.jobportal.service.SavedJobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saved-jobs")
public class SavedJobController {

    private final SavedJobService savedJobService;

    public SavedJobController(
            SavedJobService savedJobService) {

        this.savedJobService = savedJobService;
    }

    // Save Job

    @PostMapping
    public ResponseEntity<SavedJob> saveJob(
            @RequestParam Long userId,
            @RequestParam Long jobId) {

        return ResponseEntity.ok(
                savedJobService.saveJob(
                        userId,
                        jobId
                )
        );
    }

    // Get Saved Jobs

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavedJob>> getSavedJobs(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                savedJobService.getSavedJobs(userId)
        );
    }

    // Remove Saved Job

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeSavedJob(
            @PathVariable Long id) {

        savedJobService.removeSavedJob(id);

        return ResponseEntity.ok(
                "Saved job removed successfully"
        );
    }
}
