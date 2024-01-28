package com.tastecamp.api.models;

import com.tastecamp.api.dtos.RecipeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data// cria geters e setters genéricos e deixa o código bem limpo
@NoArgsConstructor// cria constructors vazios dos models
@AllArgsConstructor// cria constructors usando todos os parametros dos models
@Entity// transformei esse modelo em uma table de banco
@Table(name = "recipes")// dei o nome para essa table
public class RecipeModel {

    public RecipeModel(RecipeDTO dto) {
        this.title = dto.getTitle();
        this.ingredients = dto.getIngredients();
        this.steps = dto.getSteps();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)// primary sequencial
    private Long id;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(length = 150, nullable = false)
    private String ingredients;
    
    @Column(length = 150, nullable = false)
    private String steps;

}
