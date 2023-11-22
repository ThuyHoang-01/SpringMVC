package com.example.services;

import com.example.entities.Employee;
import com.example.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public  EmployeeService(){
        this.employeeRepository = new EmployeeRepository();
    }
    public void insertEmp(Employee employee){
        employeeRepository.setup();
        employeeRepository.insertEmployee(employee);
    }
    public Optional<Employee> findById( int id){
        employeeRepository.setup();
        return  Optional.ofNullable(employeeRepository.findEmployeeById(id));
    }
    public List<Employee> getAll() {
        employeeRepository.setup();
        return employeeRepository.listEmployee();
    }
    public void delete(int id) {
        employeeRepository.setup();
        employeeRepository.deleteById(id);
    }
}
