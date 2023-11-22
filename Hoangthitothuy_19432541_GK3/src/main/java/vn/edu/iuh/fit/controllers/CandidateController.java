package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Company;
import vn.edu.iuh.fit.services.CandidateService;
import vn.edu.iuh.fit.services.CompanyService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/CandidateController"})
public class CandidateController extends HttpServlet {
    CandidateService candidateService;
    CompanyService companyService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command==null){
            command = "LIST";
        }
        try {
            candidateService = new CandidateService();
            switch (command){
                case "LIST":listCandidates(req,resp); break;
                case  "SHOWFORM": showFormInsert(req,resp); break;
            }
        }catch (Exception e){

        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        candidateService= new CandidateService();

        String email = req.getParameter("email");
        String full_name = req.getParameter("full_name");
        int maID = Integer.parseInt(req.getParameter("company"));

        Company company = companyService.findCompanyById(maID);
        System.out.println("Success");

        candidateService.insertCan(new Candidate(email,full_name,company));

        try{
            listCandidates(req,resp);
        }catch (Exception e){

        }
    }
    private void listCandidates(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Candidate> candidates = candidateService.getAll();
        request.setAttribute("CANDIDATES", candidates);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeCandidate.jsp");
        dispatcher.forward(request,response);
    }
    private void showFormInsert(HttpServletRequest request, HttpServletResponse response) throws Exception{
        candidateService = new CandidateService();
        List<Candidate> candidate = candidateService.getAll();
        request.setAttribute("CANDIDATES", candidate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertCandidate.jsp");
        dispatcher.forward(request,response);
    }
}
