package org.zemljoradnik.mvcshop.services;

import org.zemljoradnik.mvcshop.models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zemljoradnik.mvcshop.repositories.BuyerRepository;

import java.util.List;

@Service
public class BuyerService {

    @Autowired(required = true)
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(Long id) {
        return buyerRepository.findById(id).orElse(null);
    }

/*    @Transactional
    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }*/

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }

    public List<Buyer> findBuyersByName(String name) {
        return buyerRepository.findByName(name);
    }
}
//procistiti