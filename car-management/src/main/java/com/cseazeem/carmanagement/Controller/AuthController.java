package com.cseazeem.carmanagement.Controller;


import com.cseazeem.carmanagement.DataBase.UserDao;
import com.cseazeem.carmanagement.Entities.User;
import com.cseazeem.carmanagement.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.insertUser(user.getUsername(), user.getPassword());
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginData) {
        User user = userRepository.findByUsername(loginData.get("username"))
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(loginData.get("password"), user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}

