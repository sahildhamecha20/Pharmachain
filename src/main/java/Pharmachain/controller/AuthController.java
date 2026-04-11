package Pharmachain.controller;

import Pharmachain.Dto.AuthResponse;
import Pharmachain.Dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.getUsername()) && "1234".equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(new AuthResponse("SUCCESS", "Sahil-Secret-Token"));
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }
}