package com.java.mack.sBig.app.services;

import com.java.mack.sBig.app.exceptions.ResourceNotFoundException;
import com.java.mack.sBig.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.java.mack.sBig.app.model.entity.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public String create(Product product) {
        productRepository.save(product);
        product.getId();
        return "Producto Creado Correctamente";
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long product_id){
        return productRepository.findById(product_id).orElseThrow();
    }

    public Product updateProduct(Long id, Product product) {
        Optional<Product> productId = productRepository.findById(id);
        if (productId.isPresent()) {
            Product productSaved = productId.get();

            productSaved.setName(product.getName());
            productSaved.setPrice(product.getPrice());
            productSaved.setType(product.getType());
            productSaved.setUserId(product.getUserId());

            return productRepository.save(productSaved);
        }
        throw new RuntimeException("Producto ID no encontrado");
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
