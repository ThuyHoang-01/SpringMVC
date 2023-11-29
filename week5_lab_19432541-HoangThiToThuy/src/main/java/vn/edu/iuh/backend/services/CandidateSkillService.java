package vn.edu.iuh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.backend.repositories.Candidate_SkillRepository;

@Service
public class CandidateSkillService {
    @Autowired
    private Candidate_SkillRepository candidateSkillRepository;


}
