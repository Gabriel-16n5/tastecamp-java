package com.tastecamp.api.dtos;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RecipeDTO {

    @NotBlank(message = "title can't be null or blank")// significa que é ao mesmo tempo not null e not blank
    @Size(max =150, message = "title can't be more than 150 chars length")// tamanho máximo dessa string
    private String title;

    @NotBlank
    @Size(max =150, message = "title can't be more than 150 chars length")
    private String ingredients;
    
    @NotBlank
    @Size(max =150, message = "title can't be more than 150 chars length")
    private String steps;

    @NotNull
    private Long authorId;

    private List<Long> categoryIds;
}
