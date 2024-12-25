package org.zemljoradnik.mvcshop.repositories;

import org.zemljoradnik.mvcshop.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    //List<Buyer> findById(Long buyerId);

    List<Buyer> findByName(String name);

   // void save(Buyer existingBuyer);
}
//prebaciti iz kontorlera