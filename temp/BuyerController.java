package org.zemljoradnik.mvcshop.controllers;

import org.zemljoradnik.mvcshop.models.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zemljoradnik.mvcshop.repositories.BuyerRepository;

@Controller
@RequestMapping("/buyers")
public class BuyerController {

    @Autowired(required = false)
    private BuyerRepository buyerRepository;

    // Prikazivanje svih kupaca
    @GetMapping
    public String listBuyers(Model model) {
        model.addAttribute("buyers", buyerRepository.findAll());
        return "buyers";  // JSP stranica koja prikazuje listu kupaca
    }

    // Prikazivanje forme za izmenu kupca
    @GetMapping("/edit/{id}")
    public String editBuyer(@PathVariable Long id, Model model) {
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid buyer ID:" + id));
        model.addAttribute("buyer", buyer);
        return "edit_buyer";  // JSP stranica za izmenu kupca
    }

    // Ažuriranje podataka o kupcu
    @PostMapping("/update/{id}")
    public String updateBuyer(@PathVariable Long id, @ModelAttribute Buyer updatedBuyer) {
        Buyer existingBuyer = buyerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid buyer ID:" + id));
        existingBuyer.setName(updatedBuyer.getName());
        existingBuyer.setEmail(updatedBuyer.getEmail());
        buyerRepository.save(existingBuyer);
        return "redirect:/buyers";
    }

    // Dodavanje novog kupca
    @PostMapping("/add")
    public String addBuyer(@ModelAttribute Buyer buyer) {
        buyerRepository.save(buyer);
        return "redirect:/buyers";
    }

    // Brisanje kupca
    @PostMapping("/delete/{id}")
    public String deleteBuyer(@PathVariable Long id) {
        buyerRepository.deleteById(id);
        return "redirect:/buyers";
    }
}
