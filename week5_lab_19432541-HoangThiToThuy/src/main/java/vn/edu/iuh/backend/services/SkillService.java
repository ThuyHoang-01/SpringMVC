package vn.edu.iuh.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.backend.models.Skill;
import vn.edu.iuh.backend.repositories.SkillRepository;

import java.util.List;
@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findAll(){
        return skillRepository.findAll();
    }

    public Skill getById(Long id){
        return skillRepository.getById(id);
    }

    public void saveSkill(Skill skill){
        skillRepository.save(skill);
    }

}
