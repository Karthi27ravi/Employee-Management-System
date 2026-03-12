package org.example.ems_new.Repository;

import org.example.ems_new.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

