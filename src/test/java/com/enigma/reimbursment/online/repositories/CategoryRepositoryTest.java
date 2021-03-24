package com.enigma.reimbursment.online.repositories;

import com.enigma.reimbursment.online.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    void shouldSave() {
        Category category = new Category();
        category.setCategoryName("training");
        repository.save(category);
        Category savedCategory = repository.findById(category.getId()).get();
        assertEquals(category,savedCategory);

    }

    @Test
    void testFindById() {
        Optional<Category> opGrade = repository.findById("1");
        assertTrue(opGrade.isPresent());
    }

    @Test
    void findAll(){
        List<Category> optionalCategory = repository.findAll();
        assertEquals(5,optionalCategory.size());
    }

    @Test
    void shouldUpdateCategory(){
        Category category = new Category();
        category.setId("1");
        category.setCategoryName("admin");
        repository.save(category);

        Category update = new Category();
        update.setId("1");
        update.setCategoryName("admin");

        Category result = repository.findById(category.getId()).get();
        assertThat(result.getId()).isEqualTo(update.getId());
        assertThat(result.getCategoryName()).isEqualTo(update.getCategoryName());

    }

    @Test
    void shouldDeleteEntity() {
        Category category = new Category();
        category.setId("1");
        category.setCategoryName("admin");

        repository.deleteById("1");
        assertThat(repository.findById("1")).isEmpty();
    }

}
