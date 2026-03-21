package Pharmachain.controller;

import Pharmachain.dto.LoginRequest;
import Pharmachain.dto.LoginResponse;
import Pharmachain.entity.User;
import Pharmachain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // --- REGISTER & DIRECT REDIRECT ---
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        try {
            // Password encrypt karke save kar rahe hain
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("USER");
            userRepository.save(user);

            // Bypass Login: Seedha dashboard par bhej rahe hain
            return "redirect:/dashboard";
        } catch (Exception e) {
            return "redirect:/register?error";
        }
    }

    // --- LOGIN (Optional for now, but kept for future) ---
    @PostMapping("/login")
    @ResponseBody // Taaki ye JSON return kare, redirect nahi
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.ok(new LoginResponse("Login Successful", true, user.getEmail(), user.getRole()));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponse("Invalid Credentials", false, null, null));
    }
}