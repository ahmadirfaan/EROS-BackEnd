package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,String> {
}
