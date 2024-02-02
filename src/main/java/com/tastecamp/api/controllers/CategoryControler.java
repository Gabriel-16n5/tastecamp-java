package com.tastecamp.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dtos.CategoryDTO;
import com.tastecamp.api.models.CategoryModel;
import com.tastecamp.api.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryControler {
    
    final CategoryService categoryService;

    public CategoryControler(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody @valid CategoryDTO categoryTDO) {
        CategoryModel createdCategory = categoryService.createCategory(categoryTDO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }
}
