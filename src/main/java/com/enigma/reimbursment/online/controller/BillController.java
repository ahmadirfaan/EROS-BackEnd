package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Bill;
import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.models.request.bill.ImageUploadRequest;
import com.enigma.reimbursment.online.models.response.bill.BillResponse;
import com.enigma.reimbursment.online.services.BillService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.enigma.reimbursment.online.uploadFile.FilesStorageService;
import com.enigma.reimbursment.online.uploadFile.ResponseMessages;
import com.google.common.io.Files;
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

//    @PostMapping(value = "/{id}/upload",consumes = "multipart/form-data")
//    public ResponseMessage<Bill> upload (@PathVariable String id, @Valid ImageUploadRequest model) throws IOException {
//        Reimbursement entity =  reimbursementService.findById(id);
//        if(entity == null){
//            throw new EntityNotFoundException();
//        }
//        Bill bill = new Bill();
//        bill.setBillImage(model.getFile().getOriginalFilename());
//        bill.setReimbursementId(entity);
//        bill = billService.save(bill);
//        fileService.upload(bill, model.getFile().getInputStream());
//        return ResponseMessage.success(bill);
//    }

    @PostMapping(value="/{id}/upload/file",consumes = "multipart/form-data")
    public ResponseEntity<ResponseMessages> uploadFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
        System.out.println(file.getFile().getOriginalFilename());
        System.out.println(Files.getFileExtension(file.getFile().getOriginalFilename()));
        if(Files.getFileExtension(file.getFile().getOriginalFilename()).equals("pdf")){

            Bill image = billService.filterByIdBill(id);
            if(image==null) {
                String message = "";
                String fileName = id + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
//            String fileName = generateVerificationToken() + "." + Files.getFileExtension(file.getFile().getOriginalFilename());
                try {
                    storageService.save(file.getFile(), fileName);
                    Bill bill = new Bill();
                    Reimbursement entity =  reimbursementService.findById(id);
                    bill.setReimbursementId(entity);
                    bill.setBillImage(fileName);
                    bill.setUrl("http://localhost:8080/files/"+ fileName);
                    billService.save(bill);
                    message = "Uploaded the file successfully: " + fileName;
                    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessages(message));
                } catch (Exception e) {
                    message = "Could not upload the file: " + fileName;
                    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessages(message));
                }

            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ResponseMessages("IMAGE HAS BEEN UPLOADED"));
            }
        }

        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseMessages(file.getFile().getOriginalFilename()
                            + " format file upload is not .pdf"));
        }


    }

    @PutMapping(value="/{id}/upload/file",consumes = "multipart/form-data")
    public ResponseEntity<ResponseMessages> updateFile(@PathVariable String id, ImageUploadRequest file) throws IOException {
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
            bill.setUrl("http://localhost:8080/files/"+ fileName);
            billService.save(bill);
            message = "Uploaded the file successfully: " + fileName;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessages(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + fileName;
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessages(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<BillResponse>> getListFiles() {
        List<BillResponse> billInfo = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(BillController.class, "getFile", path.getFileName().toString()).build().toString();

            return new BillResponse(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(billInfo);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        System.out.println(file.getFilename());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



//    @GetMapping("/{id}/preview")
//    public void  preview (@PathVariable String id, HttpServletResponse response)throws IOException {
//        Bill entity = billService.findById(id);
//        if(entity == null) {
//            throw new EntityNotFoundException();
//        }
//        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "filename=\"" +entity.getId() + "\"");
//        fileService.download(entity,response.getOutputStream());
//    }


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
