package com.example.spring_tymeleaf_lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC with Thymeleaf!");
        return "home"; // va chercher templates/home.html
    }
}
