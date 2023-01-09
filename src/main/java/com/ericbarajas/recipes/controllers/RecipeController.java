package com.ericbarajas.recipes.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ericbarajas.recipes.models.Recipe;
import com.ericbarajas.recipes.services.RecipeService;

@Controller
public class RecipeController {
	@Autowired
	RecipeService recipeServ;
	
	
//----------------- CREATE -------------------//
	@GetMapping("/recipes/new")
	public String newRecipe(
		@ModelAttribute("recipeObj") Recipe emptyRecipe
	) {
		return "/recipes/new.jsp";
	}
	@PostMapping("/recipes/new")
	public String processRecipe(
		@Valid @ModelAttribute("recipeObj") Recipe filledRecipe,
		BindingResult results
	) {
		// VALIDATIONS FAIL
		if(results.hasErrors()) {
			return "/recipes/new.jsp";
		}
		recipeServ.create(filledRecipe);
		return "redirect:/recipes";
		
		//to get to a details page rather than dash board(home page)
//		Recipe newRecipe = recipeServ.create(filledRecipe);
//		return "redirect:/recipes/" + newRecipe.getId();
		
	}
	
//----------------- CREATE -------------------//
	
	
//----------------- READ -------------------//
	//READ ALL
	@GetMapping("/recipes")
	public String index(
			HttpSession session, Model model
			) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/";
		}
		model.addAttribute("allRecipes", recipeServ.getAll());
		return "recipes/index.jsp";
	}
	
	//READ ONE
	@GetMapping("/recipes/{id}")
	public String oneRecipe(
		@PathVariable("id") Long id,
		Model model
	) {
		model.addAttribute("oneRecipe", recipeServ.getOne(id));
		return "/recipes/show.jsp";
	}
//----------------- READ -------------------//
	
	
//----------------- UPDATE -------------------//
	
//----------------- UPDATE -------------------//
	
//----------------- DELETE -------------------//
	
//----------------- DELETE -------------------//
}
