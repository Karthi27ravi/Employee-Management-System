package org.example.ems_new.Service;

import org.example.ems_new.Entity.Employee;
import org.example.ems_new.Exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException;
    public Employee updateEmployee(Long id, Employee employee) throws EmployeeNotFoundException;
    public void deleteEmployee(Long id) throws EmployeeNotFoundException;
}
