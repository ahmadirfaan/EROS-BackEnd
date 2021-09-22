package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Role;

import com.enigma.reimbursment.online.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role,Integer> {

    @Autowired
    protected RoleService(RoleRepository repository){
        super(repository);
    }

}
