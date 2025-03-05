package com.java.mack.sBig.app.controller;

import com.java.mack.sBig.app.model.entity.Product;
import com.java.mack.sBig.app.model.entity.Recipe;
import com.java.mack.sBig.app.services.ProductService;
import com.java.mack.sBig.app.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        String message = productService.create(product);
        return ResponseEntity.ok(message);
    }

    /**
     * Obtiene todos los productos.
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PostMapping("{productid}/recipe")
    public String crearReceta(@RequestBody Recipe recipe, @PathVariable Long productid) {
        return recipeService.create(recipe, productid);

    }
}
