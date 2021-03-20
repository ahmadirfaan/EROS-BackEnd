package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.jwt.model.LoginJwt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginJwtRepository extends JpaRepository<LoginJwt,String> {


}
