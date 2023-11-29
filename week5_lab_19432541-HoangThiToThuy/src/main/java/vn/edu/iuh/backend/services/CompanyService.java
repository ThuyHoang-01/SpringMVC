package vn.edu.iuh.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.backend.models.Company;
import vn.edu.iuh.backend.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Optional<Company> findById(long id){
        return companyRepository.findById(id);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public void deleteById(long id) {
        companyRepository.deleteById(id);
    }

    public Company update(Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(updatedCompany.getId());

        if (optionalCompany.isPresent()) {
            Company existingCompany = optionalCompany.get();
            existingCompany.setComp_name(updatedCompany.getComp_name());
            existingCompany.setAddress(updatedCompany.getAddress());

            return companyRepository.save(existingCompany);
        } else {

            return null;
        }
    }
}
