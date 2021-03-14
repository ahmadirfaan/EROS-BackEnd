package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.entities.ReimbursementGlasses;
import com.enigma.reimbursment.online.models.request.reimbursements.ReimbursementGlasesRequets;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementGlasessResponse;
import com.enigma.reimbursment.online.services.ReimbursementGlassesService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reimbursementGlasses")
@RestController
public class ReimbursementGlassesController {

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private ReimbursementGlassesService reimbursementGlassesService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/post")
    public ResponseMessage<ReimbursementGlasessResponse> add(@RequestBody ReimbursementGlasesRequets model) {
        ReimbursementGlasses entity = modelMapper.map(model, ReimbursementGlasses.class);
        Reimbursement reimbursement = reimbursementService.findById(model.getReimbursementId());
        entity.setReimbursementId(reimbursement);
        entity = reimbursementGlassesService.save(entity);
        ReimbursementGlasessResponse data = modelMapper.map(entity,ReimbursementGlasessResponse.class);
        return ResponseMessage.success(data);
    }

//    @PutMapping("/{id}")
//    public ResponseMessage<ReimbursementGlasessResponse> edit(@PathVariable String)

}
