CREATE DATABASE IF NOT EXISTS jobportal;

USE jobportal;

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT NOT NULL,

    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES roles(id)
);

CREATE TABLE companies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    website VARCHAR(255),
    location VARCHAR(150),
    recruiter_id BIGINT,

    CONSTRAINT fk_company_recruiter
        FOREIGN KEY (recruiter_id)
        REFERENCES users(id)
);

CREATE TABLE jobs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    location VARCHAR(150),
    salary DECIMAL(12,2),
    employment_type VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    company_id BIGINT NOT NULL,

    CONSTRAINT fk_job_company
        FOREIGN KEY (company_id)
        REFERENCES companies(id)
);

CREATE TABLE applications (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    applied_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) DEFAULT 'PENDING',
    user_id BIGINT NOT NULL,
    job_id BIGINT NOT NULL,

    CONSTRAINT fk_application_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT fk_application_job
        FOREIGN KEY (job_id)
        REFERENCES jobs(id),

    CONSTRAINT uk_user_job
        UNIQUE (user_id, job_id)
);

CREATE TABLE resumes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    file_name VARCHAR(255),
    file_url VARCHAR(500),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT NOT NULL UNIQUE,

    CONSTRAINT fk_resume_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
);

CREATE TABLE saved_jobs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    saved_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id BIGINT NOT NULL,
    job_id BIGINT NOT NULL,

    CONSTRAINT fk_saved_user
        FOREIGN KEY (user_id)
        REFERENCES users(id),

    CONSTRAINT fk_saved_job
        FOREIGN KEY (job_id)
        REFERENCES jobs(id),

    CONSTRAINT uk_saved_user_job
        UNIQUE (user_id, job_id)
);

-- Default Roles
INSERT INTO roles (name) VALUES
('ADMIN'),
('RECRUITER'),
('CANDIDATE');
