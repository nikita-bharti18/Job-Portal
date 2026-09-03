package com.nikita.jobportal.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecruiterDashboardResponse {

    private Long recruiterId;
    private String name;
    private String email;

    private long totalJobs;
    private long totalApplications;
    private long pendingApplications;
    private long acceptedApplications;
    private long rejectedApplications;
}
