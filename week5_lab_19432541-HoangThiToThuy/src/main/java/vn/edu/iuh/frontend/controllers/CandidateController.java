package vn.edu.iuh.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.backend.models.Address;
import vn.edu.iuh.backend.models.Candidate;
import vn.edu.iuh.backend.services.AddressService;
import vn.edu.iuh.backend.services.CandidateService;

@Controller
public class CandidateController {

    @Autowired
    private CandidateService candidateServices;

    @Autowired
    private AddressService addressService;


    @GetMapping("/home")
    public String gethome(){
        return "home";
    }

    @GetMapping("/candidate_list")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateServices.findAll());
        return "candidate/candidate_list";
    }

    @GetMapping("/add_candidate")
    public String applyCandidate(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidate/add-candidate";
    }

    @PostMapping("/add_candidate")
    public String processApplyCandidate(@ModelAttribute Candidate candidate) {
        Address address = candidate.getAddress();
        addressService.addAddress(address);
        candidateServices.addCan(candidate);
        return  "redirect:/candidate_list";
    }

    @GetMapping("/{id}")
    public String getCandidateDetails(@PathVariable Long id, Model model) {
        Candidate candidate = candidateServices.findById(id).orElse(null);
        model.addAttribute("candidate", candidate);
        return "candidate/candidate_details";
    }


}
