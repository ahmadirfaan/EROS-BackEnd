package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.entities.ReimbursementTravel;
import com.enigma.reimbursment.online.exceptions.EntityNotFondException;
import com.enigma.reimbursment.online.models.pagination.PagedList;
import com.enigma.reimbursment.online.models.request.reimbursements.ReimbursementRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.models.search.reimbursmentsearch.ReimbursementElement;
import com.enigma.reimbursment.online.models.search.reimbursmentsearch.ReimbursementSearch;
import com.enigma.reimbursment.online.services.CategoryService;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/reimbursement")
@RestController
public class ReimbursementController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<ReimbursementResponse> add(@RequestBody ReimbursementRequest model) throws ParseException {
        Reimbursement reimbursement = modelMapper.map(model,Reimbursement.class);
        reimbursement.setDateOfClaimSubmission(new SimpleDateFormat("yyyy-MM-dd").parse(model.getDateOfClaimSubmission()));
        reimbursement.setDisbursementDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getDisbursementDate()));
        Employee employee = employeeService.findById(model.getEmployeeId());
        reimbursement.setEmployeeId(employee);

        Category category = categoryService.findById(model.getCategoryId());
        reimbursement.setCategoryId(category);

        reimbursement = reimbursementService.save(reimbursement);

        ReimbursementResponse data = modelMapper.map(reimbursement, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }

    @PutMapping("/{id}")
    public ResponseMessage<ReimbursementResponse> edit(@PathVariable String id, @RequestBody ReimbursementRequest model) {
        Reimbursement entity = reimbursementService.findById(id);
        if(entity == null) {
            throw new EntityNotFondException();
        }

        Employee employee = employeeService.findById(model.getEmployeeId());
        entity.setEmployeeId(employee);
        modelMapper.map(model,entity);
        Category category = categoryService.findById(model.getCategoryId());
        entity.setCategoryId(category);
        modelMapper.map(model,entity);

        entity = reimbursementService.save(entity);

        ReimbursementResponse data = modelMapper.map(entity,ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }

//    @GetMapping
//    public ResponseMessage<List<ReimbursementResponse>> findAll(){
//        List<Reimbursement> entity = reimbursementService.findAll();
//
//        List<ReimbursementResponse> data = entity.stream()
//                .map(e -> modelMapper.map(e,ReimbursementResponse.class))
//                .collect(Collectors.toList());
//
//        return ResponseMessage.success(data);
//
//    }

    @GetMapping("/{id}")
    public ResponseMessage<ReimbursementResponse> findById(@PathVariable String id) {
        Reimbursement reimbursement = reimbursementService.findById(id);
        if(reimbursement == null)
            throw new EntityNotFondException();
        ReimbursementResponse data = modelMapper.map(reimbursement, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }

    @GetMapping
    public ResponseMessage<PagedList<ReimbursementResponse>> findAll(
            @Valid ReimbursementSearch model
            ) {
        Reimbursement search = modelMapper.map(model,Reimbursement.class);
        Page<Reimbursement> entityPage = reimbursementService.findAll(search,model.getPage(),model.getSize(),model.getSort());

        List<Reimbursement> entities = entityPage.toList();

        List<ReimbursementResponse> models = entities.stream()
                .map(e->modelMapper.map(e,ReimbursementResponse.class))
                .collect(Collectors.toList());

        PagedList<ReimbursementResponse> data = new PagedList<>(models,entityPage.getNumber(),entityPage.getSize(),entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }






}
