package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class GradeRepositoryTest {

    @Autowired
    private GradeRepository repository;

    @Test
    void shouldSave() {
        Grade grade = new Grade();
        grade.setGrade(1);
        grade.setTransportationCost(150000);
        grade.setGiveBirthCost(10000000);
        grade.setHotelCost(300000);
        grade.setMealCost(120000);
        grade.setGlasessCost(250000);
        repository.save(grade);
        Grade savedGrade = repository.findById(grade.getId()).get();
        assertEquals(grade,savedGrade);
    }
}
