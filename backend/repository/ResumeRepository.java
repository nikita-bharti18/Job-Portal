package com.nikita.jobportal.repository;

import com.nikita.jobportal.entity.Resume;
import com.nikita.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByUser(User user);

}
