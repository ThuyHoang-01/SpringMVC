package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Skill;

public interface SkillRepository extends JpaRepository<Skill , Long> {
}
