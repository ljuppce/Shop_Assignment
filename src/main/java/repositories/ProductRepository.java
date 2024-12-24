package repositories;


import models.Buyer;
import models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByBuyerId(Long productId);

    List<Product> findByName(String name);
}
