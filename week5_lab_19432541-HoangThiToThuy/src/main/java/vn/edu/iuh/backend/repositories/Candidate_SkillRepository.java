package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Candidate;
import vn.edu.iuh.backend.models.Candidate_skill;

public interface Candidate_SkillRepository extends JpaRepository<Candidate_skill, Candidate> {
}
