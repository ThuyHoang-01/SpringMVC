package vn.edu.iuh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.backend.models.Job_skill;
import vn.edu.iuh.backend.repositories.Job_SkillRepository;

import java.util.List;

@Service
public class JobSkillService {
    @Autowired
    private Job_SkillRepository jobSkillRepository;

    public void insertJobSkill(Job_skill jobSkill){
        jobSkillRepository.save(jobSkill);
    }

    public List<Job_skill> findAll(){
        return jobSkillRepository.findAll();
    }


    public void saveJobSkill(Job_skill jobSkill){
        jobSkillRepository.save(jobSkill);
    }
}