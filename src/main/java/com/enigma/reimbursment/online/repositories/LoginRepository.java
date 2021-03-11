package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<Login,String> {

    @Query(value = "SELECT * FROM login WHERE username = :username AND password = :password", nativeQuery = true)
    Login findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
