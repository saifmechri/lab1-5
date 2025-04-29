package com.example.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bienvenue sur l'API des Livres 📚 ! Utilisez /api/books pour accéder aux livres.";
    }
}

