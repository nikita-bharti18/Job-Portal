package com.nikita.jobportal.controller;

import com.nikita.jobportal.dto.dashboard.AdminDashboardResponse;
import com.nikita.jobportal.dto.dashboard.CandidateDashboardResponse;
import com.nikita.jobportal.dto.dashboard.RecruiterDashboardResponse;
import com.nikita.jobportal.service.DashboardService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(
            DashboardService dashboardService) {

        this.dashboardService =
                dashboardService;
    }

    // Candidate Dashboard

    @GetMapping("/candidate/{userId}")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<CandidateDashboardResponse>
    candidateDashboard(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                dashboardService
                        .getCandidateDashboard(userId)
        );
    }

    // Recruiter Dashboard

    @GetMapping("/recruiter/{recruiterId}")
    @PreAuthorize("hasRole('RECRUITER')")
    public ResponseEntity<RecruiterDashboardResponse>
    recruiterDashboard(
            @PathVariable Long recruiterId) {

        return ResponseEntity.ok(
                dashboardService
                        .getRecruiterDashboard(
                                recruiterId
                        )
        );
    }

    // Admin Dashboard

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<AdminDashboardResponse>
    adminDashboard() {

        return ResponseEntity.ok(
                dashboardService
                        .getAdminDashboard()
        );
    }
}
