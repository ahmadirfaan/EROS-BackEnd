package com.enigma.reimbursment.online.controllers;

import com.enigma.reimbursment.online.controller.CategoryController;
import com.enigma.reimbursment.online.entities.Category;
import com.enigma.reimbursment.online.models.response.category.CategoryResponse;
import com.enigma.reimbursment.online.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryService service;

    @MockBean
    private ModelMapper modelMapper;

    @Test
    void addShouldReturnEntity() throws Exception {
        Category category = new Category();
        category.setId("1");
        category.setCategoryName("admin");
        when(service.findById("1")).thenReturn(category);

        CategoryResponse response = new CategoryResponse();
        response.setId("1");
        response.setCategoryName("admin");
        when(modelMapper.map(any(Category.class),any(Class.class))).thenReturn(response);

        mvc.perform(get("/categories/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())))
                .andExpect(jsonPath("$.data.id", is(response.getId())))
                .andExpect(jsonPath("$.data.categoryName", is(response.getCategoryName())));
    }

    @Test
    void shouldGetAll() throws Exception {
        List<Category> category = Collections.emptyList();
        when(service.findAll()).thenReturn(category);

        RequestBuilder requestBuilder = get("/categories");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code", is(HttpStatus.OK.value())));
    }

}
