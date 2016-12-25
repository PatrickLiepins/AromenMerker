package de.start.knower.controller;

import de.start.knower.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("{recipeId}")
    public String viewRecipe(final @PathVariable Long recipeId, final Model model) {
        
        model.addAttribute("recipe", recipeRepository.findOne(recipeId));

        return "recipe/index";
    }

}