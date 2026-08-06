package com.nikita.jobportal.repository;

import com.nikita.jobportal.entity.Application;
import com.nikita.jobportal.entity.Job;
import com.nikita.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByUser(User user);

    List<Application> findByJob(Job job);

    boolean existsByUserAndJob(User user, Job job);

}
