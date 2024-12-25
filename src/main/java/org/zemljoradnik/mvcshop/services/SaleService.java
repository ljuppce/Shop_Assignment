package org.zemljoradnik.mvcshop.services;

import org.zemljoradnik.mvcshop.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zemljoradnik.mvcshop.repositories.SaleRepository;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    @Autowired(required = false)
    private SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Transactional
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    public List<Sale> findSalesByBuyerId(Long buyerId) {
        return new ArrayList<>();
        //return saleRepository.findByBuyerId(buyerId);
    }
}//procistiti
