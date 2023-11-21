package com.example.springsocial.controller;

import com.example.springsocial.model.Category;
import com.example.springsocial.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public @ResponseBody List<Category> getAllCategories(){
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id) throws Exception {
         Optional<Category> category = categoryRepository.findById(id);
         if(category.isPresent()){
             return new ResponseEntity<>(category.get(), HttpStatus.OK);
         }else{
             throw new Exception("Record not found");
         }
    }

    @PostMapping(value = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> insertCategory(@RequestBody Category newCategory) throws ServerException {
        Category category = categoryRepository.save(newCategory);
        if(category == null){
            throw new ServerException("Error occurred while adding new category");
        }else{
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        }
    }
}
