package com.java.mack.sBig.app.services;

import com.java.mack.sBig.app.exceptions.ResourceNotFoundException;
import com.java.mack.sBig.app.model.entity.Product;
import com.java.mack.sBig.app.model.entity.Recipe;
import com.java.mack.sBig.app.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private  ProductService productService;

    public String create(Recipe recipe, Long id) {
        Product p = productService.findById(id);
        recipe.setProduct(p);
        recipeRepository.save(recipe);
        return "receta guardada correctamente";
    }

}
