package repositories;

import models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    List<Buyer> findByBuyerId(Long buyerId);

    List<Buyer> findByName(String name);
}
