package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.request.bill.ImageUploadRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.bill.BillResponse;
import com.enigma.reimbursment.online.services.BillService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.enigma.reimbursment.online.uploadFile.FilesStorageService;
import com.google.common.io.Files;
import com.sun.mail.iap.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequestMapping("/bill")
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private ReimbursementService reimbursementService;

//    @Autowired
//    private FileService fileService;

    @Autowired
    FilesStorageService storageService;

    @Autowired
    ModelMapper modelMapper;

    //upload employee
    @PostMapping(value="/{id}/upload/file",consumes = "multipart/form-data")
    public ResponseMessage uploadFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
        System.out.println(file.getFile().getOriginalFilename());
        System.out.println(Files.getFileExtension(file.getFile().getOriginalFilename()));
        if(Files.getFileExtension(file.getFile().getOriginalFilename()).equals("pdf")){

            Bill image = billService.filterByIdBill(id);
            if(image==null) {
                String message = "";
                String fileName = "employee-" + id + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
//            String fileName = generateVerificationToken() + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
                try {
                    storageService.save(file.getFile(), fileName);
                    Bill bill = new Bill();
                    Reimbursement entity =  reimbursementService.findById(id);
                    bill.setReimbursementId(entity);
                    bill.setBillImage(fileName);
                    bill.setUser("employee");
                    bill.setUrl("http://localhost:8080/files/"+ fileName);
                    billService.save(bill);
                    message = "Uploaded the file successfully: " + fileName;
                    return new ResponseMessage(200,message,null);
//                            ResponseEntity.status(HttpStatus.OK).body(new ResponseMessages(message));
                } catch (Exception e) {
                    message = "Could not upload the file: " + fileName;
                    return ResponseMessage.error(417, message, null);
                }

            } else{
                return ResponseMessage.error(400,"IMAGE HAS BEEN UPLOADED", null);
            }
        }

        else {
            return ResponseMessage.error(400,file.getFile().getOriginalFilename()
                    + " format file upload is not .pdf", null);
        }
    }

    //upload admin
    @PostMapping(value="/{id}/upload/file/admin",consumes = "multipart/form-data")
    public ResponseMessage<BillResponse> uploadFileAdmin(@PathVariable String id, ImageUploadRequest file) throws IOException {
        System.out.println(file.getFile().getOriginalFilename());
        System.out.println(Files.getFileExtension(file.getFile().getOriginalFilename()));
        if(Files.getFileExtension(file.getFile().getOriginalFilename()).equals("pdf")){

            Bill image = billService.filterByIdBillAdmin(id);
            if(image==null) {
                String message = "";
                String fileName = "admin-" + id + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
//            String fileName = generateVerificationToken() + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
                try {
                    storageService.save(file.getFile(), fileName);
                    Bill bill = new Bill();
                    Reimbursement entity =  reimbursementService.findById(id);
                    bill.setReimbursementId(entity);
                    bill.setBillImage(fileName);
                    bill.setUser("admin");
                    bill.setUrl("http://localhost:8080/files/"+ fileName);
                    billService.save(bill);
                    message = "Uploaded the file successfully: " + fileName;
                    BillResponse response = new BillResponse();
                    response.setUrl(bill.getUrl());
                    response.setBillImage(bill.getBillImage());
                    return new ResponseMessage(200, message, response);
                } catch (Exception e) {
                    message = "Could not upload the file: " + fileName;
                    return new ResponseMessage(400, "Bad Request", message);
                }

            } else{
                return new ResponseMessage(417,"File has been uploaded", null);
            }
        }

        else {
            String message = "Format is not PDF";
            return new ResponseMessage(400, "Bad Request", message);
        }
    }


    @PutMapping(value="/{id}/upload/file",consumes = "multipart/form-data")
    public ResponseMessage updateFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
        Bill image = billService.filterByIdBill(id);
        billService.RemoveById(image.getId());
        String message = "";
        String fileName = generateVerificationToken() + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
        try {
            Bill bill = new Bill();
            Reimbursement entity =  reimbursementService.findById(id);
            storageService.save(file.getFile(), fileName);
            bill.setReimbursementId(entity);
            bill.setBillImage(fileName);
            bill.setUrl("http://localhost:8080/bill/files/"+ fileName);
            billService.save(bill);
            message = "Uploaded the file successfully: " + fileName;
            return ResponseMessage.success(null);
        } catch (Exception e) {
            message = "Could not upload the file: " + fileName;
            return ResponseMessage.error(417, message, null);
        }
    }

    @PutMapping(value="/{id}/upload/file/admin",consumes = "multipart/form-data")
    public ResponseEntity<String> updateFileAdmin(@PathVariable String id, ImageUploadRequest file) throws IOException {
        Bill image = billService.filterByIdBillAdmin(id);
        billService.RemoveById(image.getId());
        String message = "";
        String fileName = generateVerificationToken() + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
        try {
            Bill bill = new Bill();
            Reimbursement entity =  reimbursementService.findById(id);
            storageService.save(file.getFile(), fileName);
            bill.setReimbursementId(entity);
            bill.setBillImage(fileName);
            bill.setUrl("http://localhost:8080/files/"+ fileName);
            billService.save(bill);
            message = "Uploaded the file successfully: " + fileName;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + fileName;
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @GetMapping("/files")
    public ResponseMessage<List<BillResponse>> getListFiles() {
        List<BillResponse> billInfo = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(BillController.class, "getFile", path.getFileName().toString()).build().toString();

            return new BillResponse(filename, url);
        }).collect(Collectors.toList());

        return ResponseMessage.success(billInfo);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        System.out.println(file.getFilename());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("/{id}/file")
    public ResponseMessage findFileByIdReimburse(@PathVariable String id) {
        Bill bill = billService.filterByIdBillAdmin(id);
        if (bill == null) {
            return new ResponseMessage(404, "File not found");
        }
        return new ResponseMessage(200, "OK", bill);
    }

    protected String generateVerificationToken() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();

        while (stringBuilder.length() <= 20) { // length of the random string.
            int index = (int) (rnd.nextFloat() * characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }
}
