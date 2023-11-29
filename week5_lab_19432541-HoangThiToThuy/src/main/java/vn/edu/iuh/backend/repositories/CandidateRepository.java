package vn.edu.iuh.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.backend.models.Candidate;

public interface CandidateRepository  extends JpaRepository<Candidate, Long> {
}
