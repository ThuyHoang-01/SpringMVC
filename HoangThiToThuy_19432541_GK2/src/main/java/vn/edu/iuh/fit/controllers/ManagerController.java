package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entities.Employee;
import vn.edu.iuh.fit.entities.Manager;
import vn.edu.iuh.fit.services.EmployeeService;
import vn.edu.iuh.fit.services.ManagerService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/ManagerController"})
public class ManagerController extends HttpServlet {
    ManagerService managerService;

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
                    listManager(req, resp);
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

        if (!req.getParameter("ma_id").equals("")) {
            int ma_id = Integer.parseInt(req.getParameter("ma_id"));
            managerService.insertManager(new Manager(ma_id, name, level));

        } else managerService.insertManager(new Manager(name, level));


        System.out.println("suscess");

        try {
            listManager(req, resp);
        } catch (Exception e) {
        }
    }
    // rồi sai ở đâu vậy cưng

    private void listManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Manager> managers = managerService.getAll();
        System.out.println("get list done");
        request.setAttribute("MANAGERS", managers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeManager.jsp");
        dispatcher.forward(request, response);
    }

    private void loadFormManager(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Manager manager = managerService.findManagerById(Integer.parseInt(request.getParameter("ma_id")));
        request.setAttribute("MANAGERS", manager);
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertManager.jsp");
        dispatcher.forward(request, response);
    }
}
