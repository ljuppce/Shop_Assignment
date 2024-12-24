package services;

import models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SaleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SaleService {

    @Autowired
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
        return saleRepository.findByBuyerId(buyerId);
    }
}
