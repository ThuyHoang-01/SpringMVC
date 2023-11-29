package vn.edu.iuh.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.backend.models.Job;
import vn.edu.iuh.backend.models.Job_skill;
import vn.edu.iuh.backend.models.Skill;
import vn.edu.iuh.backend.services.JobService;
import vn.edu.iuh.backend.services.JobSkillService;
import vn.edu.iuh.backend.services.SkillService;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    @Autowired
    private JobSkillService jobSkillService;

    @Autowired
    private SkillService skillService;


    @GetMapping("/job_list")
    public String showJob(Model model){
        model.addAttribute("jobs",jobService.findAll());
        return "job/job_list";
    }



    @GetMapping("/add_job")
    public String addJob(Model model){
        model.addAttribute("job", new Job());
        return "job/add-job";
    }


    @PostMapping("/add_job")
    public String saveJob(@ModelAttribute Job job){

        Job_skill jobSkill = (Job_skill) job.getJobSkills();


        Skill skill = jobSkill.getSkill();


        jobSkillService.saveJobSkill(jobSkill);
        skillService.saveSkill(skill);


        jobService.save(job);

        return "redirect:/job_list";
    }
}
