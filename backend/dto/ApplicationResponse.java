package com.nikita.jobportal.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponse {

    private Long id;

    private String candidateName;

    private String jobTitle;

    private String status;

}
