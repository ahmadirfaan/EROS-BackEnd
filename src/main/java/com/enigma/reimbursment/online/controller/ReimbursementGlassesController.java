package com.enigma.reimbursment.online.controller;

import com.enigma.reimbursment.online.services.ReimbursementGlassesService;
import com.enigma.reimbursment.online.services.ReimbursementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
