package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Company;
import vn.edu.iuh.fit.repositories.CandidateRepo;
import vn.edu.iuh.fit.repositories.CompanyRepo;

import java.util.List;
import java.util.Optional;

public class CompanyService {
    private CompanyRepo companyRepo;
    public CompanyService(){
        this.companyRepo = new CompanyRepo();
    }
    public void insertCompany(Company company){
        companyRepo.setup();
        companyRepo.insertCompany(company);
    }
    public Company findCompanyById(int id){
        companyRepo.setup();
        return companyRepo.findById(id);
    }
    public List<Company> getAll(){
        companyRepo.setup();
        return companyRepo.listCompany();
    }
}
