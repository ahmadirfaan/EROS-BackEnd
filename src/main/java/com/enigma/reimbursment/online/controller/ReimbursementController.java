package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.model.reimbursement.ReimbursementModelFinance;
import com.enigma.reimbursment.online.models.model.reimbursement.ReimbursementModelHc;
import com.enigma.reimbursment.online.models.model.reimbursement.RequestModelEmployee;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.request.reimbursements.*;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.models.model.reimbursement.FinanceResponse;
import com.enigma.reimbursment.online.models.model.reimbursement.ReimburseEmployeeResponse;
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
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("reimburse")
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
    public ResponseMessage<ReimbursementResponse> add(@RequestBody  ReimbursementRequest model) throws ParseException {
        Reimbursement reimbursement = modelMapper.map(model,Reimbursement.class);
        Employee employee = employeeService.findById(model.getEmployeeId());
        reimbursement.setEmployeeId(employee);
        reimbursement = reimbursementService.save(reimbursement);

        Category category = categoryService.findById(model.getCategoryId());
        reimbursement.setCategoryId(category);
        reimbursement = reimbursementService.save(reimbursement);

        ReimbursementResponse data = modelMapper.map(reimbursement, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }


//    filter by id category and id employee for employee
    @PostMapping("/filter-category-employee")
    public ResponseMessage<List<ReimbursementResponse>> filterCategoryIdEmployee( @RequestBody FindCategoryRequestEmployee model) {
        List<ReimbursementResponse> reimbursements = reimbursementService.filterCategoryByIdEmployee(model.getCategoryId(),model.getEmployeeId());
        List<ReimbursementResponse> reimbursementResponses = reimbursements.stream().map(
                e -> modelMapper.map(e, ReimbursementResponse.class))
                .collect(Collectors.toList());
        if(reimbursements.isEmpty()){
            return ResponseMessage.error(200,"Data Tidak Ditmeukan", null);
        }
        System.out.println(reimbursements);
        return ResponseMessage.success(reimbursementResponses);
    }


    //filter by id category and id employee for employee
    @PostMapping("/filter-category")
    public ResponseMessage<List<Reimbursement>> filterCategory(@RequestBody FindCategoryRequest model) {
        System.out.println(model);
        List<Reimbursement> reimbursements = reimbursementService.filterCategoryById(model.getCategoryId());
        if(reimbursements == null){
            throw new EntityNotFoundException();
        }
        System.out.println(reimbursements);
        return ResponseMessage.success(reimbursements);
    }


    //filter by id employee for admin
    @PostMapping("/filter-employee-admin")
    public ResponseMessage<List<Reimbursement>> filterIdEmployee(@RequestBody FindEmployeeRequest request){
        List<Reimbursement> reimbursements = reimbursementService.filterByIdEmployee(request.getEmployeeId());
        if(reimbursements == null){
            throw new EntityNotFoundException();
        }
        return ResponseMessage.success(reimbursements);

    }


    @PostMapping("/date")
    public ResponseMessage<List<Reimbursement>> filterByDateClaim(@RequestBody FindDateOfClaim dateOfClaimSubmission) throws ParseException {
        Reimbursement reimbursement = new Reimbursement();

        List<Reimbursement> reimbursements = reimbursementService.filterByDateOfClaim(dateOfClaimSubmission.getDateOfClaimSubmission());
        System.out.println(dateOfClaimSubmission);
        return ResponseMessage.success(reimbursements);
    }


    @PutMapping("/{id}")
    public ResponseMessage<ReimbursementResponse> edit(@PathVariable String id, @RequestBody ReimbursementRequest model) {
        Reimbursement entity = reimbursementService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
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


    @GetMapping("/{id}")
    public ResponseMessage<ReimbursementResponse> findById(@PathVariable String id) {
        Reimbursement entity = reimbursementService.findById(id);
        if(entity == null)
            throw new EntityNotFoundException();
        ReimbursementResponse data = modelMapper.map(entity, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }


    @GetMapping
    public ResponseMessage<PageList<ReimbursementResponse>> findAll(@Valid ReimbursementSearch request) {

        System.out.println("request "+ request);

        Reimbursement reimbursement= modelMapper.map(request, Reimbursement.class);
        System.out.println("reimbursement" +reimbursement);

        Page<Reimbursement> pagination = reimbursementService
                .findAll(reimbursement, request.getPage(),
                request.getSize(), request.getSort());
        System.out.println("pagination:" +pagination);

        List<Reimbursement> reimbursements = pagination.toList();

        List<ReimbursementResponse> reimburseResponsePageList = reimbursements.stream()
                .map(e -> modelMapper.map(e, ReimbursementResponse.class))
                .collect(Collectors.toList());
        System.out.println("pagedlist:"+reimburseResponsePageList);

        PageList<ReimbursementResponse> response = new PageList(reimburseResponsePageList,
                pagination.getNumber(), pagination.getSize(), pagination.getTotalElements());

        System.out.println("response"+response);
        return new ResponseMessage(200, "OK", response);
    }


    //UNTUK ADMIN HC
    @PutMapping("/{id}/hc")
    public ResponseMessage<ReimbursementModelHc> editAdminHc(@PathVariable String id, @RequestBody ReimbursementModelHc model) {
        Reimbursement entity = reimbursementService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        Employee employee = employeeService.findById(entity.getEmployeeId().getId());
        entity.setEmployeeId(employee);
        modelMapper.map(model,entity);

        Category category = categoryService.findById(entity.getCategoryId().getId());
        entity.setCategoryId(category);
        modelMapper.map(model,entity);

        entity = reimbursementService.save(entity);

        ReimbursementModelHc data = modelMapper.map(entity,ReimbursementModelHc.class);
        return ResponseMessage.success(data);
    }


    //untuk employee
    @PutMapping("/{id}/employee")
    public ResponseMessage<ReimburseEmployeeResponse> editEmployee
            (@PathVariable String id, @RequestBody RequestModelEmployee model) throws ParseException {
        Reimbursement entity = reimbursementService.findById(id);

        if(entity == null) {
            throw new EntityNotFoundException();
        }

        Employee employee = employeeService.findById(entity.getEmployeeId().getId());
        entity.setEmployeeId(employee);

        Category category = categoryService.findById(entity.getCategoryId().getId());
        entity.setCategoryId(category);
        modelMapper.map(model,entity);

        entity = reimbursementService.save(entity);

        ReimburseEmployeeResponse data = modelMapper.map(entity,ReimburseEmployeeResponse.class);
        return ResponseMessage.success(data);
    }


    //untuk finance
    @PutMapping("/{id}/finance")
    public ResponseMessage<FinanceResponse> editFinance(@PathVariable String id, @RequestBody ReimbursementModelFinance model) throws ParseException {
        Reimbursement entity = reimbursementService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        Employee employee = employeeService.findById(entity.getEmployeeId().getId());
        entity.setEmployeeId(employee);
        modelMapper.map(model,entity);

        Category category = categoryService.findById(entity.getCategoryId().getId());
        entity.setCategoryId(category);
        modelMapper.map(model,entity);

        entity = reimbursementService.save(entity);

        FinanceResponse data = modelMapper.map(entity,FinanceResponse.class);
        return ResponseMessage.success(data);
    }

}
