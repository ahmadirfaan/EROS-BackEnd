package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.entities.Reimbursement;
import com.enigma.reimbursment.online.entities.ReimbursementGlasses;
import com.enigma.reimbursment.online.exceptions.EntityNotFondException;
import com.enigma.reimbursment.online.models.request.reimbursements.ReimbursementGlasesRequets;
import com.enigma.reimbursment.online.models.response.ResponseMessage;
import com.enigma.reimbursment.online.models.response.reimbursement.ReimbursementGlassesResponse;
import com.enigma.reimbursment.online.services.ReimbursementGlassesService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/glasses")
@RestController
public class ReimbursementGlassesController {

    @Autowired
    private ReimbursementService reimbursementService;

    @Autowired
    private ReimbursementGlassesService reimbursementGlassesService;

    @Autowired
    private ModelMapper modelMapper;






}
