package com.example.controllers;

import com.example.entities.Manager;
import com.example.services.ManagerService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/ManagerController"})
public class ManagerController extends HttpServlet {

    ManagerService managerService = new ManagerService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String command = req.getParameter("command");
        if (command == null) {
            command = "LIST";
        }

        try {
            managerService = new ManagerService();
            switch (command) {
                case "LIST":
                    listManagers(req, resp);
                    break;
                case "DELETE":
                    deleteManager(req, resp);
                    break;
                case "LOAD":
                    loadFormManager(req, resp);
                    break;
            }

        } catch (Exception e) {

        }



    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String level = req.getParameter("level");

        if(!req.getParameter("ma_id").equals("")){
            int ma_id = Integer.parseInt(req.getParameter("ma_id"));
            managerService.insertManager(new Manager(ma_id,name, level));

        }
        else  managerService.insertManager(new Manager(name, level));


        System.out.println("suscess");

        try {
            listManagers(req, resp);
        } catch (Exception e) {
        }
    }
    private void listManagers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Manager> managers = managerService.getAll();

        request.setAttribute("MANAGERS", managers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeManager.jsp");
        dispatcher.forward(request, response);

    }
    private void loadFormManager(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Manager manager = managerService.findMangerById(Integer.parseInt(req.getParameter("ma_id")));
        req.setAttribute("MANAGER", manager);
        RequestDispatcher dispatcher = req.getRequestDispatcher("insertManager.jsp");
        dispatcher.forward(req, resp);

    }
    private void deleteManager(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        managerService.delete(Integer.parseInt(req.getParameter("ma_id")));
        System.out.println("ok");
        listManagers(req, resp);
    }

}
