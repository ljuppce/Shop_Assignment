package controllers;

import models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.SaleRepository;
import repositories.ProductRepository;
import repositories.BuyerRepository;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    // Prikazivanje svih prodaja
    @GetMapping
    public String listSales(Model model) {
        model.addAttribute("sales", saleRepository.findAll());
        return "sales";  // JSP stranica koja prikazuje listu prodaja
    }

    // Prikazivanje forme za izmenu prodaje
    @GetMapping("/edit/{id}")
    public String editSale(@PathVariable Long id, Model model) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sale ID:" + id));
        model.addAttribute("sale", sale);
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("buyers", buyerRepository.findAll());
        return "edit_sale";  // JSP stranica za izmenu prodaje
    }

    // Ažuriranje podataka o prodaji
    @PostMapping("/update/{id}")
    public String updateSale(@PathVariable Long id, @ModelAttribute Sale updatedSale) {
        Sale existingSale = saleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid sale ID:" + id));
        existingSale.setProduct(updatedSale.getProduct());
        existingSale.setBuyer(updatedSale.getBuyer());
        existingSale.setSaleDate(updatedSale.getSaleDate());
        saleRepository.save(existingSale);
        return "redirect:/sales";  // Nakon ažuriranja, preusmeri na stranicu sa svim prodajama
    }

    // Dodavanje nove prodaje
    @PostMapping("/add")
    public String addSale(@ModelAttribute Sale sale) {
        saleRepository.save(sale);
        return "redirect:/sales";  // Preusmeri na listu prodaja
    }

    // Brisanje prodaje
    @PostMapping("/delete/{id}")
    public String deleteSale(@PathVariable Long id) {
        saleRepository.deleteById(id);
        return "redirect:/sales";  // Nakon brisanja, preusmeri na stranicu sa svim prodajama
    }
}
