package com.ericbarajas.recipes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericbarajas.recipes.models.Recipe;
import com.ericbarajas.recipes.repositories.RecipeRepository;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepo;
	
	//CREATE
	public Recipe create(Recipe newRecipe) {
		return recipeRepo.save(newRecipe);
	}
	//READ ONE
	public Recipe getOne(Long id) {
		return recipeRepo.findById(id).orElse(null);
	}
	//READ ALL
	public List<Recipe> getAll() {
		return recipeRepo.findAll();
	}
	//UPDATE
	
	//DELETE
}
