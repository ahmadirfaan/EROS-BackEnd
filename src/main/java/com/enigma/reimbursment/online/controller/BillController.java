package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.request.bill.ImageUploadRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.bill.BillResponse;
import com.enigma.reimbursment.online.services.BillService;
import com.enigma.reimbursment.online.services.FileService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.enigma.reimbursment.online.uploadFile.FileInfo;
import com.enigma.reimbursment.online.uploadFile.FilesController;
import com.enigma.reimbursment.online.uploadFile.FilesStorageService;
import com.enigma.reimbursment.online.uploadFile.ResponseMessages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
    FilesStorageService storageService;

    @Autowired
    ModelMapper modelMapper;

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

    @PostMapping(value="/{id}/upload/file",consumes = "multipart/form-data")
    public ResponseEntity<ResponseMessages> uploadFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
        String message = "";
        try {
            storageService.save(file.getFile());
            Bill bill = new Bill();
            Reimbursement entity =  reimbursementService.findById(id);
            bill.setReimbursementId(entity);
            bill.setBillImage(file.getFile().getOriginalFilename());
            bill.setUrl("http://localhost:8080/files/"+file.getFile().getOriginalFilename());
            bill = billService.save(bill);;
            message = "Uploaded the file successfully: " + file.getFile().getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessages(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getFile().getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessages(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<BillResponse>> getListFiles() {
        List<BillResponse> billInfo = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

            return new BillResponse(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(billInfo);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
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
