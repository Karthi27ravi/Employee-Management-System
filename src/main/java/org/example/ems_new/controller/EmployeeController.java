package org.example.ems_new.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
    @GetMapping("/login")

    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")

    public String registerPage() {
        return "register";
    }


}
