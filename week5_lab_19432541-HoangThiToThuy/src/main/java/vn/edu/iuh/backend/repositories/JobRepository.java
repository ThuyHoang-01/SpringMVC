package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}
