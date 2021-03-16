package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Role;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.request.role.RoleRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.role.RoleResponse;
import com.enigma.reimbursment.online.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("role")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<RoleResponse> add(@RequestBody @Valid RoleRequest model) {
        Role entity = modelMapper.map(model,Role.class);
        entity = roleService.save(entity);

        RoleResponse data = modelMapper.map(entity,RoleResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<RoleResponse> edit(@PathVariable Integer id, @RequestBody RoleRequest model) {
        Role entity = roleService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        modelMapper.map(model,entity);
        entity = roleService.save(entity);

        RoleResponse data = modelMapper.map(entity,RoleResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<RoleResponse> findById(@PathVariable Integer id) {
        Role entity = roleService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        RoleResponse data = modelMapper.map(entity,RoleResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<List<RoleResponse>> findAll() {
       List<Role> entity = roleService.findAll();
       List<RoleResponse> data = entity.stream().map(e -> modelMapper.map(e,RoleResponse.class))
               .collect(Collectors.toList());
       return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<RoleResponse> removeById(@PathVariable Integer id) {
        Role entity = roleService.RemoveById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        RoleResponse data = modelMapper.map(entity,RoleResponse.class);
        return ResponseMessage.success(data);
    }


}
