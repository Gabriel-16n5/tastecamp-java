package com.tastecamp.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tastecamp.api.dtos.RecipeDTO;
import com.tastecamp.api.models.RecipeModel;
import com.tastecamp.api.repositories.RecipeRepository;

@Service
public class RecipeService {
    
    final RecipeRepository recipeRepository;
    RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeModel> findAll() {
        return recipeRepository.findAll();
    }

    public Optional<RecipeModel> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public RecipeModel save(RecipeDTO dto) {
        RecipeModel receita = new RecipeModel(dto);
        return recipeRepository.save(receita);
    }

    public RecipeModel update(RecipeDTO dto, Long id) {
        RecipeModel newRecipe = new RecipeModel(dto);
        newRecipe.setId(id);
        return recipeRepository.save(newRecipe);
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

}
