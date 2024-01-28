package com.tastecamp.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tastecamp.api.dtos.RecipeDTO;
import com.tastecamp.api.models.RecipeModel;
import com.tastecamp.api.repositories.RecipeRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/recipes")
public class RecipeController {
    
    final RecipeRepository recipeRepository;
    RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping    
    public ResponseEntity<List<RecipeModel>> getRecipes() {
        List<RecipeModel> recipes = recipeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(recipes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRecipeById(@PathVariable Long id) {
        Optional<RecipeModel> recipe = recipeRepository.findById(id);

        if(!recipe.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id inválido");
        }

        return ResponseEntity.status(HttpStatus.OK).body(recipe);
    }

    @PostMapping
    public ResponseEntity<RecipeModel> createRecipe(@RequestBody @Valid RecipeDTO body) {
        RecipeModel receita = new RecipeModel(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeRepository.save(receita));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO body) {
        Optional<RecipeModel> recipe = recipeRepository.findById(id);

        if(!recipe.isPresent()){
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível atualizar");
        }
        // \/ isso aqui é para o update funcionar e manter o id antigo
        RecipeModel newRecipe = new RecipeModel(body);
        newRecipe.setId(id);
        recipeRepository.save(newRecipe);
        return ResponseEntity.status(HttpStatus.OK).body(recipeRepository.save(newRecipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Receita deletada");
    }

}