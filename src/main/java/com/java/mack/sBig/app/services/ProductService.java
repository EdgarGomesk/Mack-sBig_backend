package com.java.mack.sBig.app.services;

import com.java.mack.sBig.app.exceptions.ResourceNotFoundException;
import com.java.mack.sBig.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.mack.sBig.app.model.entity.Product;

import java.util.List;

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

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }
}
