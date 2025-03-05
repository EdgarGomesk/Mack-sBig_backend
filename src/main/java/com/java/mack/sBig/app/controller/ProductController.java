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

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        String message = productService.create(product);
        return ResponseEntity.ok(message);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok("Producto actualizado correctamente!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Producto eliminado correctamente!");
    }
}
