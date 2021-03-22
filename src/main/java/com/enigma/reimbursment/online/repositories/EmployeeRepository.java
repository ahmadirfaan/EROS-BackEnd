package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = "SELECT * FROM employee WHERE email_verification_token = :token", nativeQuery = true)
    Employee checkVerificationEmailToken(@Param("token") String token);

    @Query(value = "SELECT * FROM employee WHERE is_verified_email = true AND is_completed = true", nativeQuery = true)
    List<Employee> getAll();

    //filter by nama employee
    @Query(value = "SELECT * FROM employee WHERE fullname = :fullname", nativeQuery = true)
    List<Employee> findByNameEmployee(@Param("fullname") String fullname);

    //tambahan
    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET is_verified_hc = :isVerifiedHc WHERE id = :id", nativeQuery = true)
    Employee changeIsVerifiedHc(@Param("id") String id,@Param("isVerifiedHc") Boolean isVerifiedHc);

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET is_verified_email = true WHERE email_verification_token = :token", nativeQuery = true)
    Integer changeIsVerifiedEmail(@Param("token") String token);

    @Query(value = "SELECT * FROM employee WHERE id_login = :id_login", nativeQuery = true)
    Employee findIdLogin(@Param("id_login") String idLogin);

    @Query(value = "SELECT COUNT(id) FROM employee", nativeQuery = true)
    Integer getCountEmployee();

    @Query(value = "SELECT COUNT(id) FROM employee WHERE employee_status = 'ACTIVE'", nativeQuery = true)
    Integer getCountEmployeeActive();




}
