package Pharmachain.controller;

import Pharmachain.entity.User;
import Pharmachain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ✅ Register API
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        User savedUser = userRepository.save(user);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("userId", savedUser.getId());

        return ResponseEntity.ok(response);
    }

    // ✅ Login API (FIXED)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        // Email se user fetch
        User dbUser = userRepository.findByEmail(user.getEmail());

        if (dbUser == null) {
            return ResponseEntity.status(401).body("Invalid email");
        }

        // Password check
        if (!dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        // Success response
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("userId", dbUser.getId());
        response.put("role", dbUser.getRole());

        return ResponseEntity.ok(response);
    }
}