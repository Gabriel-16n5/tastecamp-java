package com.tastecamp.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tastecamp.api.models.RecipeModel;

public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {
    // com essa interface irei conseguir usar tudo que preciso para pegar as informações do banco, tudo graças ao jpa, pois,
    // nesse extends que eu fiz ele já traz todas as funções genéricas para o funcionamento do banco.
}
