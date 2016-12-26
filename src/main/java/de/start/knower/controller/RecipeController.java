package de.start.knower.controller;

import de.start.knower.CreateRecipeForm;
import de.start.knower.model.Recipe;
import de.start.knower.repository.FlavorRepository;
import de.start.knower.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final FlavorRepository flavorRepository;

    public RecipeController(RecipeRepository recipeRepository, FlavorRepository flavorRepository) {
        this.recipeRepository = recipeRepository;
        this.flavorRepository = flavorRepository;
    }

    @GetMapping("{recipeId}")
    public String viewRecipe(final @PathVariable Long recipeId, final Model model) {

        model.addAttribute("recipe", recipeRepository.findOne(recipeId));
        return "recipe/index";
    }

    @GetMapping("{recipeId}/delete")
    public String deleteRecipe(final @PathVariable Long recipeId,
            @RequestParam Long userId) {
        recipeRepository.delete(recipeId);
        return "redirect:/users-dashboard/" + userId;
    }

    @GetMapping("{recipeId}/edit")
    public String editRecipe(final @PathVariable Long recipeId, final CreateRecipeForm createRecipeForm, final Model model) {
        Recipe recipe = recipeRepository.findOne(recipeId);
        model.addAttribute("recipe", recipe);
        model.addAttribute("flavors", flavorRepository.findAll());
createRecipeForm.setFlavorId(recipe.getFlavor().getId());
        
        return "recipe/edit";
    }

}
