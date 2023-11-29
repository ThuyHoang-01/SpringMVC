package vn.edu.iuh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.backend.models.Job;
import vn.edu.iuh.backend.repositories.JobRepository;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll(){
        return jobRepository.findAll();
    }

    public void save(Job job){
        jobRepository.save(job);
    }
}