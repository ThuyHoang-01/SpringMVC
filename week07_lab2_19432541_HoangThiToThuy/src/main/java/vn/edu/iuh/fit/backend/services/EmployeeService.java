package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public Employee saveEmployee(Employee employee);

    public Optional<Employee> findEmployeeById(Long id);

    public void deleteEmployee(Long id);

}
