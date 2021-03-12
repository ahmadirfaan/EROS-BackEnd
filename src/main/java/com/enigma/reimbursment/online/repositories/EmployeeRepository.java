package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
