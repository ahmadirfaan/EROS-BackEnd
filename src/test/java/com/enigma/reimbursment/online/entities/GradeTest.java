package com.enigma.reimbursment.online.entities;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GradeTest {

    @Test
    void setGradeEntity() {
        Grade expected = new Grade();
        expected.setId("abc");
        expected.setGrade(1);
        expected.setGlasessCost(150000);
        expected.setGiveBirthCost(700000);
        expected.setHotelCost(300000);
        expected.setTransportationCost(400000);
        expected.setMealCost(100000);

    }
}
