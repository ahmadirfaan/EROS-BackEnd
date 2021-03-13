package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "SELECT * FROM employee WHERE email_verification_token = :token", nativeQuery = true)
    Employee checkVerificationEmailToken(@Param("token") String token);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET is_verified_email = true WHERE email_verification_token = :token", nativeQuery = true)
    Integer changeIsVerifiedEmail(@Param("token") String token);
}
