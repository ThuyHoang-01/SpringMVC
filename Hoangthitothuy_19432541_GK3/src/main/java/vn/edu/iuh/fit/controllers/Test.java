package vn.edu.iuh.fit.controllers;

import vn.edu.iuh.fit.entities.Company;
import vn.edu.iuh.fit.services.CompanyService;

public class Test {
    public static void main(String[] args) {
        CompanyService companyService = new CompanyService();
        Company company = new Company(1,"Hoàng Tố Thùy","IUH");
        company.setCom_id(5);
    }
}
