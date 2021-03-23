package com.enigma.reimbursment.online.services;

import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.entities.Grade;
import com.enigma.reimbursment.online.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService service;

    @Mock
    private CategoryRepository repository;

    @Test
    void shouldSave() {
        Category input = new Category();
        input.setId("1");
        input.setCategoryName("admin");

        Category output = new Category ();
        output.setId("1");
        output.setCategoryName("admin");

        when(repository.save(any())).thenReturn(output);
        Category result = service.save(input);
        assertEquals(output,result);
    }

    @Test
    void shouldRemove(){
        Category output = new Category();
        output.setId("5");
        when(repository.findById(anyString()))
                .thenReturn(Optional.of(output));
        Category result = service.RemoveById(output.getId());
        assertEquals(output,result);
    }

    @Test
    void shouldFindById(){
        Category input = new Category();
        input.setId("1");
        when(repository.findById(anyString()))
                .thenReturn(Optional.of(input));
        Category result = service.findById(input.getId());
        assertEquals(input,result);
    }

    @Test
    void shouldFindAll() {
        List<Category> category = new ArrayList();
        category.add(new Category("1"));
        category.add(new Category("2"));
        category.add(new Category("3"));
        when(service.findAll()).thenReturn(category);
        List<Category> expected = service.findAll();
        assertEquals(category,expected);


    }
}
