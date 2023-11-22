package com.example.controllers;

import com.example.entities.Employee;
import com.example.entities.Manager;
import com.example.services.EmployeeService;
import com.example.services.ManagerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/EmployeeController"})
public class EmployeeController extends HttpServlet {
    EmployeeService employeeService;
    ManagerService managerService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        if (command== null){
            command="LIST";
        }
        try {
            employeeService = new EmployeeService();
            switch (command){
                case "LIST": listManagers(req, resp); break;
                case "DELETE": deleteManager(req, resp); break;
                case "SHOWFORM": showFormInsert(req, resp); break;
            }
        }catch (Exception e){

        }
    }
    private void  showFormInsert(HttpServletRequest req , HttpServletResponse resp) throws Exception{
        managerService = new ManagerService();

        List<Manager> managers = managerService.getAll();
        req.setAttribute("MANAGERS",managers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("insertEmployee.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        managerService = new ManagerService();
        String name = req.getParameter("name");
        String old = req.getParameter("old");

        int maID = Integer.parseInt(req.getParameter("manager"));
        Manager manager = managerService.findMangerById(maID);

        System.out.println("suscess");
        employeeService.insertEmp(new Employee(name,old,manager));
        try {
            listManagers(req,resp);
        } catch (Exception e){}



    }
    private void listManagers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Employee> employees = employeeService.getAll();
        request.setAttribute("EMPLOYEES", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeEmployee.jsp");
        dispatcher.forward(request, response);

    }
    private void deleteManager(HttpServletRequest req, HttpServletResponse resp) throws  Exception{
        employeeService.delete(Integer.parseInt(req.getParameter("emp_id")) );
        System.out.println("ok");
        listManagers(req,resp);
    }
}
