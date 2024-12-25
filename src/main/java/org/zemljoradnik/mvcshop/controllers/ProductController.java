package org.zemljoradnik.mvcshop.controllers;

import org.zemljoradnik.mvcshop.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zemljoradnik.mvcshop.repositories.ProductRepository;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired()
    private ProductRepository productRepository;



    // Prikazivanje svih proizvoda
    @GetMapping
    public String listProducts(Model model) {
        List<Product> all = productRepository.findAll();
        System.out.println("Products in DB: {}" + all.size());
        model.addAttribute("products", all);
        return "products";  // JSP stranica koja prikazuje listu proizvoda
    }

    // Prikazivanje forme za izmenu proizvoda
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID:" + id));
        model.addAttribute("product", product);
        return "edit_product";  // JSP stranica za izmenu proizvoda
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "edit_product";  // JSP stranica za izmenu proizvoda
    }

    @PostMapping("/update")
    public String saveProduct(@ModelAttribute Product updatedProduct) {
        Product existingProduct;
        System.out.println(updatedProduct.getId() + " " + updatedProduct.getName());
        if (updatedProduct.getId() == null ) {
            existingProduct = new Product();
        } else {
            existingProduct = productRepository.findById(updatedProduct.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product ID:" + updatedProduct.getId()));
        }
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        productRepository.saveAndFlush(existingProduct);
        return "redirect:/products";
    }
/*
ovo moze brisanje
    // Ažuriranje podataka o proizvodu
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID:" + id));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        productRepository.save(existingProduct);
        return "redirect:/products";
    }
*/
    // Dodavanje novog proizvoda
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    // Brisanje proizvoda
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
