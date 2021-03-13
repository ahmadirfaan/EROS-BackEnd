package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Login,String> {

    @Query(value = "SELECT * FROM login WHERE email = :email AND password = :password", nativeQuery = true)
    Login findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT COUNT(email) FROM login WHERE email = :email", nativeQuery = true)
    Integer findByEmail(@Param("email") String email);
}
