package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void testFindById() {
        Optional<Grade> opGrade = repository.findById("1");
        assertTrue(opGrade.isPresent());
    }

    @Test
    void findAll() {
        List<Grade> optionalGrade = repository.findAll();
        assertEquals(4,optionalGrade.size());
    }

    @Test
    void shouldUpdateGrade() {
        Grade grade = new Grade();
        grade.setId("1");
        grade.setGrade(2);
        grade.setGlasessCost(300000);
        grade.setMealCost(100000);
        grade.setGiveBirthCost(100000);
        grade.setTransportationCost(100000);

        repository.save(grade);

        Grade update = new Grade();
        update.setId("1");
        update.setGrade(2);
        update.setGlasessCost(300000);
        update.setMealCost(100000);
        update.setGiveBirthCost(100000);
        update.setTransportationCost(100000);

        Grade result = repository.findById(grade.getId()).get();

        assertThat(result.getId()).isEqualTo(grade.getId());
        assertThat(result.getGrade()).isEqualTo(grade.getGrade());
        assertThat(result.getGiveBirthCost()).isEqualTo(grade.getGiveBirthCost());
        assertThat(result.getGlasessCost()).isEqualTo(grade.getGlasessCost());
        assertThat(result.getHotelCost()).isEqualTo(grade.getHotelCost());
        assertThat(result.getMealCost()).isEqualTo(grade.getMealCost());
        assertThat(result.getTransportationCost()).isEqualTo(grade.getTransportationCost());

    }

    @Test
    void shouldDeleteEntity() {
        Grade grade = new Grade();
        grade.setId("1");
        grade.setGrade(1);
        grade.setTransportationCost(150000);
        grade.setGiveBirthCost(10000000);
        grade.setHotelCost(300000);
        grade.setMealCost(120000);
        grade.setGlasessCost(250000);

        repository.deleteById("1");
        assertThat(repository.findById("1")).isEmpty();

    }
}
