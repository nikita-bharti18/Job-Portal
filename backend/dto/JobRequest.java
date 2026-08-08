package com.nikita.jobportal.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JobRequest {

    private String title;

    private String description;

    private String location;

    private BigDecimal salary;

    private String employmentType;

}
