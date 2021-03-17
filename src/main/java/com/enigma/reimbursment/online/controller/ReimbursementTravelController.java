package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.entities.ReimbursementTravel;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.request.reimbursements.travel.ReimbursementTravelRequest;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.travel.ReimbursementTravelResponse;
import com.enigma.reimbursment.online.models.search.reimbursementTravel.ReimbursementTravelSearch;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.enigma.reimbursment.online.services.ReimbursementTravelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/reimbursetravel")
@RestController
public class ReimbursementTravelController {
    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReimbursementTravelService reimbursementTravelService;

    @GetMapping("/{id}")
    public ResponseMessage<ReimbursementTravelResponse> findById(@PathVariable String id) {
        ReimbursementTravel reimbursementTravel = reimbursementTravelService.findById(id);
        if (reimbursementTravel == null)
            throw new EntityNotFoundException();
        ReimbursementTravelResponse data = modelMapper.map(reimbursementTravel, ReimbursementTravelResponse.class);
        return ResponseMessage.success(data);

    }

    @PostMapping
    public ResponseMessage<ReimbursementTravelResponse> add(@RequestBody ReimbursementTravelRequest model) throws ParseException {
        ReimbursementTravel reimbursementTravel = modelMapper.map(model, ReimbursementTravel.class);
        reimbursementTravel.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getStartDate()));
        reimbursementTravel.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getEndDate()));

        Reimbursement reimbursement = reimbursementService.findById(model.getReimbursementId());
        reimbursementTravel.setReimbursementId(reimbursement);
        reimbursementTravel = reimbursementTravelService.save(reimbursementTravel);


        ReimbursementTravelResponse data = modelMapper.map(reimbursementTravel, ReimbursementTravelResponse.class);
        return ResponseMessage.success(data);


    }

    @GetMapping
    public ResponseMessage<PageList<ReimbursementTravelResponse>> findAll(
            @Valid ReimbursementTravelSearch model
    ) {
        ReimbursementTravel search = modelMapper.map(model, ReimbursementTravel.class);
        Page<ReimbursementTravel> entityPage = reimbursementTravelService.findAll(search, model.getPage(),
                model.getSize(), model.getSort());
        List<ReimbursementTravel> entities = entityPage.toList();
        List<ReimbursementTravelResponse> models = entities.stream()
                .map(e -> modelMapper.map(e, ReimbursementTravelResponse.class))
                .collect(Collectors.toList());

        System.out.println("cek hasil:");
        System.out.println(models.toString());

        PageList<ReimbursementTravelResponse> data = new PageList<>(models, entityPage.getNumber(),
                entityPage.getSize(), entityPage.getTotalElements());
        return ResponseMessage.success(data);
    }

    @DeleteMapping("{id}")
    public ResponseMessage<ReimbursementTravelResponse> removeById(@PathVariable String id) {
        ReimbursementTravel entity = reimbursementTravelService.RemoveById(id);
//        ReimbursementTravel entity = reimbursementTravelService.delete(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }

        ReimbursementTravelResponse data = modelMapper.map(entity, ReimbursementTravelResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ReimbursementTravelResponse> edit(@PathVariable String id, @RequestBody @Valid ReimbursementTravelRequest request) throws ParseException {
        ReimbursementTravel entity = reimbursementTravelService.findById(id);
        if (entity == null) {
            throw new EntityNotFoundException();
        }
        entity.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getStartDate()));
        entity.setEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getEndDate()));

        ReimbursementTravel reimbursement = reimbursementTravelService.findById(entity.getId());
        System.out.println(reimbursement.getReimbursementId());
        entity.setReimbursementId(reimbursement.getReimbursementId());
        entity = reimbursementTravelService.save(entity);


        ReimbursementTravelResponse data = modelMapper.map(entity, ReimbursementTravelResponse.class);
        return ResponseMessage.success(data);

    }

}
