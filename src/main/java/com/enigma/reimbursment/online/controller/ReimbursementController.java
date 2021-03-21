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
import com.enigma.reimbursment.online.models.request.reimbursements.claim.RequestStatusOnFinance;
import com.enigma.reimbursment.online.models.request.reimbursements.claim.RequestStatusOnHc;
import com.enigma.reimbursment.online.models.request.reimbursements.claim.RequestStatusReject;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementResponse;
import com.enigma.reimbursment.online.models.response.reimbursement.claim.ResponseStatusOnFinance;
import com.enigma.reimbursment.online.models.response.reimbursement.claim.ResponseStatusOnHc;
import com.enigma.reimbursment.online.models.response.reimbursement.claim.ResponseStatusReject;
import com.enigma.reimbursment.online.models.response.reimbursement.model.FinanceResponse;
import com.enigma.reimbursment.online.models.response.reimbursement.model.ReimburseEmployeeResponse;
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
        reimbursement.setDateOfClaimSubmission(new SimpleDateFormat("yyyy-MM-dd").parse(model.getDateOfClaimSubmission()));
        reimbursement.setDisbursementDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getDisbursementDate()));
        Employee employee = employeeService.findById(model.getEmployeeId());
        reimbursement.setEmployeeId(employee);
        reimbursement = reimbursementService.save(reimbursement);

        Category category = categoryService.findById(model.getCategoryId());
        reimbursement.setCategoryId(category);
        reimbursement = reimbursementService.save(reimbursement);

        ReimbursementResponse data = modelMapper.map(reimbursement, ReimbursementResponse.class);
        return ResponseMessage.success(data);

    }

    //change status on_HC
    @PutMapping("/{id}/change-status-hc")
    public ResponseMessage<ResponseStatusOnHc> editStatusOnHc(@PathVariable String id,@RequestBody RequestStatusOnHc request) {

        Reimbursement reimbursement = reimbursementService.findById(id);
        if(reimbursement == null){
            throw new EntityNotFoundException();
        }

        Employee employee = employeeService.findById(reimbursement.getEmployeeId().getId());
        reimbursement.setEmployeeId(employee);

        Category category = categoryService.findById(reimbursement.getCategoryId().getId());
        reimbursement.setCategoryId(category);
        modelMapper.map(request,reimbursement);

        reimbursement = reimbursementService.save(reimbursement);

        ResponseStatusOnHc data = modelMapper.map(reimbursement,ResponseStatusOnHc.class);
        return ResponseMessage.success(data);
    }

    //change status on_finance
    @PutMapping("/{id}/change-status-finance")
    public ResponseMessage<ResponseStatusOnFinance> editStatusOnHc(@PathVariable String id, @RequestBody RequestStatusOnFinance request) {

        Reimbursement reimbursement = reimbursementService.findById(id);
        if(reimbursement == null){
            throw new EntityNotFoundException();
        }

        Employee employee = employeeService.findById(reimbursement.getEmployeeId().getId());
        reimbursement.setEmployeeId(employee);

        Category category = categoryService.findById(reimbursement.getCategoryId().getId());
        reimbursement.setCategoryId(category);
        modelMapper.map(request,reimbursement);

        reimbursement = reimbursementService.save(reimbursement);

        ResponseStatusOnFinance data = modelMapper.map(reimbursement,ResponseStatusOnFinance.class);
        return ResponseMessage.success(data);
    }

    //change status on_reject
    @PutMapping("/{id}/change-status-reject")
    public ResponseMessage<ResponseStatusReject> editStatusOnHc(@PathVariable String id, @RequestBody RequestStatusReject request) {

        Reimbursement reimbursement = reimbursementService.findById(id);
        if(reimbursement == null){
            throw new EntityNotFoundException();
        }

        Employee employee = employeeService.findById(reimbursement.getEmployeeId().getId());
        reimbursement.setEmployeeId(employee);

        Category category = categoryService.findById(reimbursement.getCategoryId().getId());
        reimbursement.setCategoryId(category);
        modelMapper.map(request,reimbursement);

        reimbursement = reimbursementService.save(reimbursement);

        ResponseStatusReject data = modelMapper.map(reimbursement,ResponseStatusReject.class);
        return ResponseMessage.success(data);
    }


//    filter by id category and id employee for employee
    @PostMapping("/filter-category-employee")
    public ResponseMessage<List<Reimbursement>> filterCategoryIdEmployee( @RequestBody FindCategoryRequestEmployee model) {
        List<Reimbursement> reimbursements = reimbursementService.filterCategoryByIdEmployee(model.getCategoryId(),model.getEmployeeId());
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

    //filter status adminOnHc (success,reject,onFinance,hc)
    @PostMapping("/filter-status-admin")
    public ResponseMessage<List<Reimbursement>> filterStatusAdmin(@RequestBody FindStatusAdminRequest model) {

        List<Reimbursement> reimbursements = reimbursementService.filterStatusAdminOnHc(model.getStatusReject()
                ,model.getStatusOnHc(),model.getStatusSuccess(),model.getStatusOnFinance());

        System.out.println("reimbursement :" +reimbursements);
        return ResponseMessage.success(reimbursements);
    }

    //filter by date
    @PostMapping("/date")
    public ResponseMessage<List<Reimbursement>> filterByDateClaim(@RequestBody FindDateOfClaim model) throws ParseException {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getStartDate()));
        reimbursement.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getStartDate()));
        List<Reimbursement> reimbursements = reimbursementService.filterByDateOfClaim(model.getStartDate(), model.getEndDate());
        return ResponseMessage.success(reimbursements);
    }

    //filter by date,category and id employee
    @PostMapping("/filter-date-category-employee")
    public ResponseMessage<List<Reimbursement>> filterByDateCategoryAndEmployee(@RequestBody FindDateCategoryAndIdEmployee model) throws ParseException {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getStartDate()));
        reimbursement.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getStartDate()));

        List<Reimbursement> reimbursements = reimbursementService.filterByDateCategoryAndIdEmployee(model.getCategoryId(), model.getEmployeeId(),model.getStartDate(), model.getEndDate() );
        System.out.println("test: "+reimbursements);
        return ResponseMessage.success(reimbursements);
    }

    //filter-date-employee
    @PostMapping("/filter-date-employee")
    public ResponseMessage<List<Reimbursement>> filterByDateIdEmployee(@RequestBody FindDateAndIdEmployee request) throws ParseException {
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getStartDate()));
        reimbursement.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getEndDate()));

        List<Reimbursement> reimbursements = reimbursementService.filterByDateAndIdEmployee(request.getEmployeeId(),request.getStartDate()
                ,request.getEndDate());
        System.out.println("reimbursement:" +reimbursements);
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
        entity.setDateOfClaimSubmission(new SimpleDateFormat("yyyy-MM-dd")
                .parse(model.getDateOfClaimSubmission()));

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
        entity.setDisbursementDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getDisbursementDate()));

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
