package Pharmachain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // register.html
    }

    @GetMapping("/dashboard")
    public String showdashboard() {
        return "dashboard"; // dashboard.html
    }
    @GetMapping("/bill")
    public String billing() {
        return "bill";
    }

    @GetMapping("/inventory")
    public String inventory() {
        return "inventory"; // inventory.html
    }

    @GetMapping("/audit-logs")
    public String auditLogs() {
        return "audit-logs"; // audit-logs.html
    }
}