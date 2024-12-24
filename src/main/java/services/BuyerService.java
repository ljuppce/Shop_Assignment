package services;

import models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BuyerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

    @Transactional
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }

    public List<Buyer> findBuyersByName(String name) {
        return buyerRepository.findByName(name);
    }
}
