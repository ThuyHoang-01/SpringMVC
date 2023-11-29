package vn.edu.iuh.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.backend.models.Address;
import vn.edu.iuh.backend.models.Company;
import vn.edu.iuh.backend.services.AddressService;
import vn.edu.iuh.backend.services.CompanyService;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyServices;
    @Autowired
    private AddressService addressService;


    @GetMapping("/company_list")
    public String showCompany(Model model){
        model.addAttribute("companies",companyServices.findAll());
        return "company/company_list";
    }

    @GetMapping("/add-company")
    public String addCompany(Model model){
        model.addAttribute("company", new Company());
        return "company/add-company";
    }

    @PostMapping("/add-company")
    public String saveCompany(@ModelAttribute Company company){
        Address address = company.getAddress();
        addressService.addAddress(address);
        companyServices.save(company);
        return "redirect:/company_list";
    }

}
