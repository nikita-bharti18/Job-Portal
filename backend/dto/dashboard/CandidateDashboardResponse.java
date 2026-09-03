package com.nikita.jobportal.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateDashboardResponse {

    private Long userId;
    private String name;
    private String email;

    private long totalApplications;
    private long pendingApplications;
    private long acceptedApplications;
    private long rejectedApplications;

    private long savedJobs;
}
