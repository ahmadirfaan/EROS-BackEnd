package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.repositories.GradeRepository;
import org.springframework.data.domain.Example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {

    @InjectMocks
    private GradeService service;

    @Mock
    private GradeRepository repository;

    @Test
    void shouldSave(){
        Grade input = new Grade();
        input.setGrade(1);
        input.setTransportationCost(150000);
        input.setGiveBirthCost(10000000);
        input.setHotelCost(300000);
        input.setMealCost(120000);
        input.setGlasessCost(250000);

        Grade output = new Grade();
        output.setGrade(1);
        output.setTransportationCost(150000);
        output.setGiveBirthCost(10000000);
        output.setHotelCost(300000);
        output.setMealCost(120000);
        output.setGlasessCost(250000);

        when(repository.save(any())).thenReturn(output);
        Grade result = service.save(input);
        assertEquals(output,result);
    }

    @Test
    void shouldRemove(){
        Grade output = new Grade();
        output.setId("5");
        when(repository.findById(anyString()))
                .thenReturn(Optional.of(output));
        Grade result = service.RemoveById(output.getId());
        assertEquals(output,result);
    }

    @Test
    void shouldFindById(){
        Grade input = new Grade();
        input.setId("1");
        when(repository.findById(anyString()))
                .thenReturn(Optional.of(input));
        Grade result = service.findById(input.getId());
        assertEquals(input,result);
    }

//    @Test
//    void shouldFindAll() {
//        List<Grade> grades = new ArrayList();
////        grades.add(new Grade("1"));
////        grades.add(new Grade("2"));
////        grades.add(new Grade("3"));
//
//        when(repository.findAll()).thenReturn(grades);
//        List<Grade> expected = service.findAll();
//        assertNotNull(null,null);

//    }

}
