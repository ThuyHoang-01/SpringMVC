package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Company;
import vn.edu.iuh.fit.services.CompanyService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/CompanyController"})
public class CompanyController extends HttpServlet {
    CompanyService companyService = new CompanyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command==null){
            command = "LIST";
        }
        try {
            companyService = new CompanyService();
            switch (command){
                case "LIST":listCompanys(req,resp); break;
                case  "LOAD": loadFormCompany(req,resp); break;
            }
        }catch (Exception e){

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comp_name = req.getParameter("comp_name");
        String about = req.getParameter("about");

        if(!req.getParameter("com_id").equals("")){
            int com_id = Integer.parseInt(req.getParameter("com_id"));
            companyService.insertCompany(new Company(com_id,about,comp_name));
        }
        else companyService.insertCompany(new Company(comp_name,about));
        System.out.println(" Success");

        try{
            listCompanys(req,resp);
        }catch (Exception e){

        }
    }
    private void listCompanys(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Company> companies = companyService.getAll();
        request.setAttribute("COMPANYS", companies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeCompany.jsp");
        dispatcher.forward(request,response);
    }
    private void loadFormCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Company company = companyService.findCompanyById(Integer.parseInt(request.getParameter("com_id")));
        request.setAttribute("COMPANYS", company);
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertCompany.jsp");
        dispatcher.forward(request,response);
    }
}
