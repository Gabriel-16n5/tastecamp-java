package com.tastecamp.api.models;

import java.util.List;

import com.tastecamp.api.dtos.RecipeDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
        this.author = new UserModel();
        this.author.setId(dto.getAuthorId());
    }

    public RecipeModel(RecipeDTO dto, UserModel user, List<CategoryModel> categories) {
        this.title = dto.getTitle();
        this.ingredients = dto.getIngredients();
        this.steps = dto.getSteps();
        this.author = user;
        this.categories = categories;
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

    @ManyToOne
    @JoinColumn(name = "authorId")
    private UserModel author;

    @ManyToMany
    @JoinTable(
        name = "recipe_category",
        joinColumns = @JoinColumn(name = "recipeId"),
        inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private List<CategoryModel> categories;
}
