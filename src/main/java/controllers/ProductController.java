package controllers;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repositories.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Prikazivanje svih proizvoda
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
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
