package org.zemljoradnik.mvcshop.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //za pocetnu
    @GetMapping("/")
    public String home() {
        return "index";
    }
}
