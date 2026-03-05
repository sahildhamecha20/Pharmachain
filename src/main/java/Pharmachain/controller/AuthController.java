package Pharmachain.controller;

import Pharmachain.entity.User;
import Pharmachain.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(Map.of(
                    "message", "Registration Successful!",
                    "userId", savedUser.getId()
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Registration failed: " + e.getMessage()));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword())
                .map(user -> ResponseEntity.ok(Map.of(
                        "message", "Login successful!",
                        "userId", user.getId(),
                        "role", user.getRole(),
                        "username", user.getUsername()
                )))
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid email or password")));
    }
}