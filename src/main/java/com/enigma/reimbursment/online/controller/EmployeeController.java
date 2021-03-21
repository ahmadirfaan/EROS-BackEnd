package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Employee;
import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.entities.Login;
import com.enigma.reimbursment.online.enums.*;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.request.employee.*;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponseDashboard;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponsePage;
import com.enigma.reimbursment.online.models.response.employee.EmployeeResponse;
import com.enigma.reimbursment.online.models.response.login.LoginResponse;
import com.enigma.reimbursment.online.services.EmployeeService;
import com.enigma.reimbursment.online.services.GradeService;
import com.enigma.reimbursment.online.services.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    LoginService loginService;

    @Autowired
    GradeService gradeService;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping("/{id}")
    public ResponseMessage<EmployeeResponse> findById(@Valid @PathVariable String id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new EntityNotFoundException();
        }

        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return ResponseMessage.success(response);
    }


//    @GetMapping
//    public ResponseMessage<PageList<EmployeeResponse>> findAll(@Valid EmployeeSearch request) {
//        Employee employee = modelMapper.map(request, Employee.class);
//
//        Page<Employee> pagination = employeeService.findAll(employee, request.getPage(),
//                request.getSize(), request.getSort());
//        System.out.println(pagination);
//        List<EmployeeResponse> employeResponsePageList = pagination.stream()
//                .map(e -> modelMapper.map(e, EmployeeResponse.class))
//                .collect(Collectors.toList());
//        PageList<EmployeeResponse> response = new PageList(employeResponsePageList,
//                pagination.getNumber(), pagination.getSize(), pagination.getTotalElements());
//        System.out.println(employeResponsePageList);
//        return new ResponseMessage(200, "OK", response);
//    }


    @GetMapping
    public ResponseMessage<List<Employee>> findAll() {
        List<Employee> employee = employeeService.getAll();
        return new ResponseMessage(200, "OK", employee);
    }


//    @PostMapping
//    public ResponseMessage<EmployeeResponse> add(@RequestBody @Valid EmployeeRequest request) {
//        Employee employee = modelMapper.map(request, Employee.class);
//        Login login = loginService.findById(employee.getLogin().getId());  //Apakah masih dibutuhkan controller Add????
//        employee.setLogin(login);
//        employee.setBloodType(BloodType.getBloodType(request.getBloodType()));
//        employee.setGender(Gender.getGender(request.getGender()));
//        employee.setEmployeeStatus(EmployeeStatus.getEmployeeStatus(request.getEmployeeStatus()));
//        employee.setMaritalStatus(MaritalStatus.getMaritalStatus(request.getMaritalStatus()));
//        employee.setReligion(Religion.getReligion(request.getReligion()));
//        employee.setEmployeeType(EmployeeType.getEmployeeType(request.getEmployeeType()));
//        employee = employeeService.save(employee);
//        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
//        return ResponseMessage.success(response);
//    }


    @PutMapping("/ganti-password")
    public ResponseMessage<LoginResponse> changePassword( @RequestBody  EmployeeRequestChangePassword request) {
        Login login = loginService.findById(request.getIdLogin());

        if(login == null) {
            throw new EntityNotFoundException();
        }

        modelMapper.map(request,login);


        login = loginService.save(login);

            LoginResponse data = modelMapper.map(login,LoginResponse.class);
        return ResponseMessage.success(data);
    }



    @PutMapping("/{id}")
    public ResponseMessage<EmployeeResponse> edit(@PathVariable String id,@RequestBody @Valid EmployeeRequest request) throws ParseException {

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new EntityNotFoundException();
        }

        Login login = loginService.findById(employee.getLogin().getId());
        employee.setLogin(login);

        Grade grade = gradeService.findById(employee.getGrade().getId());
        employee.setGrade(grade);


        modelMapper.map(request, employee);
        employee.setJoinDate(LocalDate.parse(request.getJoinDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        employee.setLogin(login);
        employee.setGrade(grade);
        employee = employeeService.save(employee);

        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return ResponseMessage.success(response);
    }

    @PutMapping("/editform/{id}")
    public ResponseMessage<EmployeeResponse> editForm(
            @PathVariable String id, @RequestBody @Valid EmployeeRequestEditForm request) throws ParseException {
        Employee employee = employeeService.findById(id);
        if(employee == null) {
            throw new EntityNotFoundException();
        }
        Login login = loginService.findById(employee.getLogin().getId());
        employee.setLogin(login);
        modelMapper.map(request, employee);
        employee.setDateOfBirth(LocalDate.parse(request.getDateOfBirth(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        employee.setLogin(login);
        employee.setBloodType(BloodType.getBloodType(request.getBloodType()));
        employee.setGender(Gender.getGender(request.getGender()));
        employee.setMaritalStatus(MaritalStatus.getMaritalStatus(request.getMaritalStatus()));
        employee.setReligion(Religion.getReligion(request.getReligion()));
        employee.setCompleted(true);
        employee = employeeService.save(employee);
        System.out.println("data employee:" +employee);
        EmployeeResponse response = modelMapper.map(employee,EmployeeResponse.class);
        return ResponseMessage.success(response);
    }

    //change status employee active or non-active
//    @PutMapping("/{id}/changeStatusEmployee")
//    public ResponseMessage<Employee> changeStatusEmployee(@PathVariable String id) {
//        Employee employee = employeeService.findById(id);
//        if(employee==null) {
//            throw new EntityNotFoundException();
//        }
//        employee = employeeService.save(employee);
//        return null;
//    }

    //change status hc
//    @PutMapping("/{id}/changeStatusHc")
//    public ResponseMessage<Boolean> changeIsVerifiedHc(@RequestBody EmployeeRequestVerifiedHc request) {
//        return null;
//    }

    @GetMapping("/idlogin/{idLogin}")
    public ResponseMessage<EmployeeResponse> getEmployeeByIdLogin(@PathVariable String idLogin) {
        Employee employee = employeeService.findByIdLogin(idLogin);
        if(employee == null) {
            throw  new EntityNotFoundException();
        }
        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return ResponseMessage.success(response);
    }

}
