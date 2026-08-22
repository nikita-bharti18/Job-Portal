package com.nikita.jobportal.controller;

import com.nikita.jobportal.entity.Company;
import com.nikita.jobportal.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(
            @RequestParam String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String website,
            @RequestParam(required = false) String location,
            @RequestParam Long recruiterId) {

        Company company = companyService.createCompany(
                name,
                description,
                website,
                location,
                recruiterId
        );

        return ResponseEntity.ok(company);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                companyService.getCompany(id)
        );
    }
}
