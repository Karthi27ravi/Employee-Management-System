package org.example.ems_new.Exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id){
        super("Employee not found: " + id);
    }
}
