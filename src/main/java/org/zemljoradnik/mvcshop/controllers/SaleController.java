package org.zemljoradnik.mvcshop.controllers;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zemljoradnik.mvcshop.models.Product;
import org.zemljoradnik.mvcshop.models.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zemljoradnik.mvcshop.repositories.SaleRepository;
import org.zemljoradnik.mvcshop.repositories.ProductRepository;
import org.zemljoradnik.mvcshop.repositories.BuyerRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired(required = false)
    private SaleRepository saleRepository;

    @Autowired(required = false)
    private ProductRepository productRepository;

    @Autowired(required = false)
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




   @PostMapping("/update")
    public String updateSale(@ModelAttribute Sale updatedSale, Model model) {
        Product p = productRepository.findById(updatedSale.getProduct().getId()).get();
       if (p.getQuantity() == null) {
           model.addAttribute("errorMessage", "Proizvod nije pronađen.");
           return "sales";
       }

        if (p.getQuantity() < updatedSale.getQuantity()) {
            //throw new RuntimeException("Invalid quantity, max: " + p.getQuantity());
            model.addAttribute("errorMessage", "Nema dovoljno na stanju. Maksimalna količina: " + p.getQuantity());
            return "sales";
        }

        p.setQuantity(p.getQuantity() - updatedSale.getQuantity());
        productRepository.save(p);










    //  Sale existingSale = saleRepository.findById(id)
       //         .orElseThrow(() -> new IllegalArgumentException("Invalid sale ID:" + id));
        Sale existingSale = new Sale();
        existingSale.setProduct(updatedSale.getProduct());
        existingSale.setBuyer(updatedSale.getBuyer());
        existingSale.setSaleDate(updatedSale.getSaleDate());
        existingSale.setQuantity(updatedSale.getQuantity());
        saleRepository.save(existingSale);
        return "redirect:/sales";  // Nakon ažuriranja, preusmeri na stranicu sa svim prodajama pregled
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
    @GetMapping("/edit/new")
    public String newSale(Model model) {
        Sale sale = new Sale();
        model.addAttribute("sale", sale);
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("buyers", buyerRepository.findAll());
        return "edit_sale";  // JSP stranica za izmenu prodaje
    }
}
