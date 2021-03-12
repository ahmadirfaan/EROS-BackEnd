package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.exceptions.EntityNotFondException;
import com.enigma.reimbursment.online.models.request.grade.GradeRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.grade.GradeResponse;
import com.enigma.reimbursment.online.services.GradeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("grades")
@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<GradeResponse> add(@RequestBody @Valid GradeRequest model) {
        Grade entity = modelMapper.map(model, Grade.class);
        entity = gradeService.save(entity);

        GradeResponse data = modelMapper.map(entity,GradeResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<GradeResponse> edit(@PathVariable String id, @RequestBody GradeRequest model) {
        Grade entity = gradeService.findById(id);
        if(entity == null) {
            throw new EntityNotFondException();
        }
        modelMapper.map(model,entity);
        entity = gradeService.save(entity);

        GradeResponse data = modelMapper.map(entity,GradeResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<GradeResponse> findById(@PathVariable String id) {
        Grade entity = gradeService.findById(id);
        if(entity == null) {
            throw new EntityNotFondException();
        }
        GradeResponse data = modelMapper.map(entity,GradeResponse.class);
        return ResponseMessage.success(data);

    }

    @GetMapping
    public ResponseMessage<List<GradeResponse>> findAll() {

        List<Grade> entity = gradeService.findAll();
        List<GradeResponse> data = entity.stream().map(e -> modelMapper.map(e,GradeResponse.class))
                .collect(Collectors.toList());
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<GradeResponse> removeById(@PathVariable  String id) {
        Grade entity = gradeService.RemoveById(id);
        if(entity == null) {
            throw new EntityNotFondException();
        }
        GradeResponse data = modelMapper.map(entity,GradeResponse.class);
        return ResponseMessage.success(data);
    }

}
