package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.request.bill.ImageUploadRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.services.BillService;
import com.enigma.reimbursment.online.services.FileService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private FileService fileService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping(value = "/{id}/upload",consumes = "multipart/form-data")
    public ResponseMessage<Bill> upload (@PathVariable String id, @Valid ImageUploadRequest model) throws IOException {
        Reimbursement entity =  reimbursementService.findById(id);
        if(entity == null){
            throw new EntityNotFoundException();
        }
        Bill bill = new Bill();
        bill.setBillImage(model.getFile().getOriginalFilename());
        bill.setReimbursementId(entity);
        bill = billService.save(bill);
        fileService.upload(bill, model.getFile().getInputStream());
        return ResponseMessage.success(bill);
    }

    @GetMapping("/{id}/preview")
    public void  preview (@PathVariable String id, HttpServletResponse response)throws IOException {
        Bill entity = billService.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" +entity.getId() + "\"");
        fileService.download(entity,response.getOutputStream());
    }


}
