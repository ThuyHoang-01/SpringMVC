package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Employee;
import vn.edu.iuh.fit.reposirories.EmployeeRepo;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepo employeeRepo;
    public EmployeeService(){
        this.employeeRepo = new EmployeeRepo();
    }
    public void insertEmp(Employee employee){
        employeeRepo.setup();
        employeeRepo.insertEmployee(employee);
    }
    public Optional<Employee> findById(int id){
        employeeRepo.setup();
        return Optional.ofNullable(employeeRepo.findEmployeeById(id));
    }
    public List<Employee> getAll(){
        employeeRepo.setup();
        return employeeRepo.listEmployee();
    }
}
