package com.juan.reservanatural.config;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @GetMapping
    public String home() {
        return "Probando";
    }

    @GetMapping("/welcome")
    public String sayHii(Authentication authentication) {
        return "Bienvenido a la API de Reserva Natural";
    }
}
