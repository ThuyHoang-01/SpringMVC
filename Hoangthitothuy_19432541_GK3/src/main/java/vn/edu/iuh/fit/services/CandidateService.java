package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepo;

import java.util.List;
import java.util.Optional;

public class CandidateService {
    private CandidateRepo candidateRepo;
    public CandidateService(){
        this.candidateRepo = new CandidateRepo();
    }
    public void insertCan(Candidate candidate){
        candidateRepo.setup();
        candidateRepo.insertCandidate(candidate);
    }
    public Optional<Candidate> findById(int id){
        candidateRepo.setup();
        return Optional.ofNullable(candidateRepo.findCandidateById(id));
    }
    public List<Candidate> getAll(){
        candidateRepo.setup();
        return candidateRepo.listCandidate();
    }
}
