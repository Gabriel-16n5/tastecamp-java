package com.tastecamp.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// cria geters e setters genéricos e deixa o código bem limpo
@NoArgsConstructor// cria constructors vazios dos models
@AllArgsConstructor// cria constructors usando todos os parametros dos models
public class RecipeModel {
    private Long id;
    private String title;
    private String ingredients;
    private String steps;



}
