package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getEmployee(Model model) {
         List<Employee> employees =  employeeService.getAllEmployee();
         model.addAttribute("employees", employees);
         return "list-employee";
    }

    @GetMapping("/employee/add")
    public String formEmployee(Model model) {
        model.addAttribute("emp", new Employee());
        return "add-employee";
    }

    @GetMapping("/employee/update/{id}")
    public String formUpdateEmployee(Model model, @PathVariable("id") long id) {
        Optional<Employee> em = employeeService.findEmployeeById(id);
        model.addAttribute("emp", em.get());
        return "add-employee";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println(employee);
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String saveEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
