package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
