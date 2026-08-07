package com.nikita.jobportal.repository;

import com.nikita.jobportal.entity.SavedJob;
import com.nikita.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedJobRepository extends JpaRepository<SavedJob, Long> {

    List<SavedJob> findByUser(User user);

}
