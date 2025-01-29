package com.juan.reservanatural.config;



import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/api/v1/welcome")
    public String sayHii()
    {
        return "Welcome " +"to Spring Security.";
    }

    @GetMapping("/api/v1/private")
    public String sayHola()
    {
        return "Welcome " +"to Spring Security.";
    }
}
