package com.nikita.jobportal.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class JobResponse {

    private Long id;

    private String title;

    private String description;

    private String location;

    private BigDecimal salary;

    private String companyName;

}
