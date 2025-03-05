package com.java.mack.sBig.app.controller;

import com.java.mack.sBig.app.model.entity.Recipe;
import com.java.mack.sBig.app.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("{product_id}/recipe")
    public ResponseEntity<String> createRecipe(@PathVariable Long product_id, @RequestBody Recipe recipe) {
        recipeService.create(recipe, product_id);
        return ResponseEntity.ok("Recipe successfully created!");
    }
}
