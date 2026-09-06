package com.nikita.jobportal.dto.dashboard;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminDashboardResponse {

    private long totalUsers;
    private long totalCandidates;
    private long totalRecruiters;

    private long totalCompanies;
    private long totalJobs;
    private long totalApplications;
}
