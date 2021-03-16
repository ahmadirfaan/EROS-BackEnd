package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.entities.ReimbursementTraining;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.pagination.PageList;
import com.enigma.reimbursment.online.models.request.reimbursements.training.ReimbursementTrainingRequest;
import com.enigma.reimbursment.online.models.request.reimbursements.training.ReimbursementTrainingSearch;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementTrainingResponse;
import com.enigma.reimbursment.online.services.ReimbursementService;
import com.enigma.reimbursment.online.services.ReimbursementTrainingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/training")
@RestController
public class ReimbursementTrainingController {

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ReimbursementTrainingService reimbursementTrainingService;

    @PostMapping
    public ResponseMessage<ReimbursementTrainingResponse> add(@RequestBody ReimbursementTrainingRequest model) throws ParseException {
        ReimbursementTraining reimbursementTraining = modelMapper.map(model, ReimbursementTraining.class);

        reimbursementTraining.setTrainingEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getTrainingStartDate()));
        reimbursementTraining.setTrainingEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getTrainingEndDate()));

        Reimbursement reimbursement = reimbursementService.findById(model.getReimbursementId());
        reimbursementTraining.setReimbursementId(reimbursement);
        reimbursementTraining = reimbursementTrainingService.save(reimbursementTraining);

        ReimbursementTrainingResponse data = modelMapper.map(reimbursementTraining, ReimbursementTrainingResponse.class);
        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ReimbursementTrainingResponse> edit(@PathVariable String id, @RequestBody @Valid ReimbursementTrainingRequest model) throws ParseException {
        ReimbursementTraining reimbursementTraining = reimbursementTrainingService.findById(id);

        if (reimbursementTraining == null) {
            throw new EntityNotFoundException();
        }
        reimbursementTraining.setTrainingEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getTrainingEndDate()));
        reimbursementTraining.setTrainingStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getTrainingStartDate()));

        reimbursementTraining.setReimbursementId(reimbursementTraining.getReimbursementId());
        reimbursementTraining = reimbursementTrainingService.save(reimbursementTraining);

        ReimbursementTrainingResponse data = modelMapper.map(reimbursementTraining, ReimbursementTrainingResponse.class);
        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageList<ReimbursementTrainingResponse>> findAll(@Valid ReimbursementTrainingSearch model) {
        ReimbursementTraining search = modelMapper.map(model, ReimbursementTraining.class);

        Page<ReimbursementTraining> entityPage = reimbursementTrainingService.findAll(search, model.getPage(), model.getSize(), model.getSort());

        List<ReimbursementTraining> entities = entityPage.toList();

        List<ReimbursementTrainingResponse> models = entities.stream()
                .map(e -> modelMapper.map(e, ReimbursementTrainingResponse.class))
                .collect(Collectors.toList());

        PageList<ReimbursementTrainingResponse> data = new PageList<>(models, entityPage.getNumber(),
                entityPage.getSize(), entityPage.getTotalElements());

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ReimbursementTrainingResponse> findById(@PathVariable String id) {
        ReimbursementTraining reimbursementTraining = reimbursementTrainingService.findById(id);
        if (reimbursementTrainingService.findById(id) != null) {
            ReimbursementTrainingResponse data = modelMapper.map(reimbursementTraining, ReimbursementTrainingResponse.class);
            return ResponseMessage.success(data);
        }
        throw new EntityNotFoundException();
    }

//    @DeleteMapping("{id}")
//    public ResponseMessage<ReimbursementTrainingResponse> removeById(@PathVariable String id) {
//        ReimbursementTraining reimbursementTraining = reimbursementTrainingService.RemoveById(id);
//        if (reimbursementTraining == null) {
//            throw new EntityNotFondException();
//        }
//        ReimbursementTrainingResponse data = modelMapper.map(reimbursementTraining,ReimbursementTrainingResponse.class);
//        return ResponseMessage.success(data);
//
//    }

}
