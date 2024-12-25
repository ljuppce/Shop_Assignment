package org.zemljoradnik.mvcshop.repositories;


import org.zemljoradnik.mvcshop.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //List<Product> findByBuyerId(Long productId);

    List<Product> findByName(String name);

    void deleteById(Long id);
}
