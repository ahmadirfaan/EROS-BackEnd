package com.enigma.reimbursment.online.controllers;

import com.enigma.reimbursment.online.controller.GradeController;
import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.exceptions.EntityNotFoundException;
import com.enigma.reimbursment.online.models.response.grade.GradeResponse;
import com.enigma.reimbursment.online.services.GradeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GradeController.class)
public class GradeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GradeService service;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void addShouldSuccess() throws Exception {
        Grade grade = new Grade();
        grade.setId("1");
        grade.setGrade(1);
        grade.setTransportationCost(150000);
        grade.setGiveBirthCost(10000000);
        grade.setHotelCost(300000);
        grade.setMealCost(120000);
        grade.setGlasessCost(250000);
        when(service.save(any())).thenReturn(grade);

        GradeResponse response = new GradeResponse();
        response.setId(grade.getId());
        response.setGrade(grade.getGrade());
        response.setGlasessCost(grade.getGlasessCost());
        response.setHotelCost(grade.getHotelCost());
        response.setMealCost(grade.getMealCost());
        response.setTransportationCost(grade.getTransportationCost());
        response.setGiveBirthCost(grade.getGiveBirthCost());
        when(modelMapper.map(any(Grade.class), any(Class.class))).thenReturn(response);

        RequestBuilder requestBuilder = post("/grades")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"grade\" : \"1\"}");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.grade", is(response.getGrade())));
    }

    @Test
    void getShouldReturnEntity() throws Exception {
        Grade grade = new Grade();
        grade.setId("1");
        grade.setGrade(1);
        grade.setTransportationCost(150000);
        grade.setGiveBirthCost(10000000);
        grade.setHotelCost(300000);
        grade.setMealCost(120000);
        grade.setGlasessCost(250000);
        when(service.findById("1")).thenReturn(grade);

        GradeResponse response = new GradeResponse();
        response.setId(grade.getId());
        response.setGrade(grade.getGrade());
        response.setGlasessCost(grade.getGlasessCost());
        response.setHotelCost(grade.getHotelCost());
        response.setMealCost(grade.getMealCost());
        response.setTransportationCost(grade.getTransportationCost());
        response.setGiveBirthCost(grade.getGiveBirthCost());
        when(modelMapper.map(any(Grade.class), any(Class.class))).thenReturn(response);

        mvc.perform(get("/grades/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.grade", is(grade.getGrade())));
    }

    @Test
    void shouldDeleteEntity() throws Exception {
        String gradeId = "1";
        Grade grade = new Grade(gradeId);
        Mockito.when(service.RemoveById("1")).thenReturn(grade);

        String responseId = "1";
        GradeResponse response = new GradeResponse(responseId);
        when(modelMapper.map(any(Grade.class),any(Class.class))).thenReturn(response);

        mvc.perform(delete("/grades/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.grade", is(grade.getGrade())));
    }

    @Test
    void editShouldSuccess() throws Exception {
        Grade grade = new Grade();
        grade.setId("1");
        when(service.findById(grade.getId())).thenReturn(grade);
        if(grade == null){
            throw new EntityNotFoundException();
        }

        GradeResponse gradeResponse = new GradeResponse();
        gradeResponse.setId(grade.getId());
        when(modelMapper.map(any(Grade.class),any(Class.class))).thenReturn(gradeResponse);

        mvc.perform(get("/grades/1")
                            .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.grade", is(grade.getGrade())));

        Grade entity = new Grade();
        entity.setId(grade.getId());
        when(service.save(any())).thenReturn(entity);

        RequestBuilder request = put("/grades/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"grade\" : \"1\"}");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.grade", is(entity.getGrade())));
    }

    @Test
    void checkResponseEntityPostERROR() throws Exception {

        RequestBuilder request = post("/grades")
                .contentType(MediaType.APPLICATION_JSON)
                .content("asdoksokdowkokdow");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is(HttpStatus.BAD_REQUEST.value())))
                .andExpect(result -> assertNotNull(result.getResolvedException()));
    }

}
