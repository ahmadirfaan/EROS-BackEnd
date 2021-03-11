package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginService extends AbstractService<Login, String> {

    @Autowired
    protected LoginRepository loginRepository;

    @Autowired
    protected LoginService(LoginRepository repository){
        super(repository);
    }

    public Login findByUsernameAndPassword(String username, String password){
        List<Login> users = loginRepository.findAll();
        Login data = null;

            for(Login user : users){
                if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                    data = user;
                }
            }


        return data;
    }


}
