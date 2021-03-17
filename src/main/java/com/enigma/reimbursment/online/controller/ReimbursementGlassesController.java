package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.entities.ReimbursementGlasses;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.pagination.PageSearch;
import com.enigma.reimbursment.online.models.request.reimbursements.glasses.ReimbursementGlassesRequest;
import com.enigma.reimbursment.online.models.request.reimbursements.glasses.ReimbursementGlassesSearch;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.glasses.ReimbursementGlassesResponse;
import com.enigma.reimbursment.online.services.ReimbursementGlassesService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/glasses")
@RestController
public class ReimbursementGlassesController {

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private ReimbursementGlassesService reimbursementGlassesService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseMessage<ReimbursementGlassesResponse> add(@RequestBody ReimbursementGlassesRequest model){
        ReimbursementGlasses reimbursementGlasses = modelMapper.map(model,ReimbursementGlasses.class);

        Reimbursement reimbursement = reimbursementService.findById(model.getReimbursementId());
        reimbursementGlasses.setReimbursementId(reimbursement);
        reimbursementGlasses = reimbursementGlassesService.save(reimbursementGlasses);

        ReimbursementGlassesResponse data = modelMapper.map(reimbursementGlasses,ReimbursementGlassesResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ReimbursementGlassesResponse> findById(@PathVariable String id) {
        ReimbursementGlasses reimbursementGlasses = reimbursementGlassesService.findById(id);
        if(reimbursementGlasses == null)
            throw new EntityNotFoundException();
        ReimbursementGlassesResponse data = modelMapper.map(reimbursementGlasses,ReimbursementGlassesResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<ReimbursementGlassesResponse>> findAll(
            @Valid ReimbursementGlassesSearch model
            ) {
        ReimbursementGlasses search = modelMapper.map(model,ReimbursementGlasses.class);

        Page<ReimbursementGlasses> entityPage = reimbursementGlassesService.findAll(search,model.getPage()
                ,model.getSize(),model.getSort());

        List<ReimbursementGlasses> entities = entityPage.toList();

        List<ReimbursementGlassesResponse> models = entities.stream()
                .map(e->modelMapper.map(e,ReimbursementGlassesResponse.class))
                .collect(Collectors.toList());

        PageList<ReimbursementGlassesResponse> data = new PageList<>(models, entityPage.getNumber(), entityPage.getSize(), entityPage.getTotalElements());

        return ResponseMessage.success(data);

    }

    @PutMapping("/{id}/edit")
    public ResponseMessage<ReimbursementGlassesResponse> edit(@PathVariable String id, @RequestBody @Valid ReimbursementGlassesRequest model) {
        ReimbursementGlasses reimbursementGlasses = reimbursementGlassesService.findById(id);

        if(reimbursementGlasses == null) {
            throw  new EntityNotFoundException();
        }
        Reimbursement reimbursement = reimbursementService.findById(model.getReimbursementId());
        reimbursementGlasses.setReimbursementId(reimbursement);

        modelMapper.map(model,reimbursementGlasses);

        reimbursementGlasses = reimbursementGlassesService.save(reimbursementGlasses);
        ReimbursementGlassesResponse data = modelMapper.map(reimbursementGlasses,ReimbursementGlassesResponse.class);

        return ResponseMessage.success(data);

    }









}
