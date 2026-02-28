package org.example.ems_new.Controller;

import jakarta.validation.Valid;
import org.example.ems_new.Entity.Employee;
import org.example.ems_new.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

private EmployeeService employeeService;

public EmployeeController(EmployeeService employeeService){
    this.employeeService = employeeService;
}

@GetMapping("/employees")
public List<Employee> getEmployee(){
    return employeeService.getAllEmployees();
}

@GetMapping("/employees/{id}")
public Employee getEmployeeById(@PathVariable Long id){
    return employeeService.getEmployeeById(id);
}

@PostMapping("/employees")
public Employee createEmployee(@Valid @RequestBody Employee employee){
    return employeeService.createEmployee(employee);
}

@PutMapping("/employees/{id}")
public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee){
    return employeeService.updateEmployee(id, employee);
}

@DeleteMapping("/employees/{id}")
public void deleteEmployee(@PathVariable Long id){
    employeeService.deleteEmployee(id);
}
}
