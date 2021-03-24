package com.enigma.reimbursment.online.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GradeRepositoryTest {

    @Autowired
    private GradeRepository repository;

    @Test
    void shouldSave() {

    }
}
