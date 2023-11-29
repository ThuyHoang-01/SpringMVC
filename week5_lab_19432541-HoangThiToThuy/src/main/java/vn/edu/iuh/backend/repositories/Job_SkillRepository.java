package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Job;
import vn.edu.iuh.backend.models.Job_skill;

public interface Job_SkillRepository extends JpaRepository<Job_skill, Job> {
}
