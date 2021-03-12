package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends AbstractService<Login, String> {

    @Autowired
    protected LoginRepository loginRepository;

    @Autowired
    protected LoginService(LoginRepository repository){
        super(repository);
    }

    public Login findByEmailAndPassword(String email, String password){
        return loginRepository.findByUsernameAndPassword(email,password);
    }


}
