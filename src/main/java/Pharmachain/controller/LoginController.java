package Pharmachain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/user-login")
    public String splash() {
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}