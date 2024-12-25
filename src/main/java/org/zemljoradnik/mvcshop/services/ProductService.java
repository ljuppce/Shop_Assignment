package org.zemljoradnik.mvcshop.services;

import org.zemljoradnik.mvcshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zemljoradnik.mvcshop.repositories.ProductRepository;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired(required = false)
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findProductsByName(String name) {
        return productRepository.findByName(name);
    }
}
//procistiti