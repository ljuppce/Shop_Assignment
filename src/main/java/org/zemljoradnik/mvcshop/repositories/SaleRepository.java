package org.zemljoradnik.mvcshop.repositories;

import org.zemljoradnik.mvcshop.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    //List<Sale> findByBuyerId(Long buyerId);
}
