package com.example.portfolio.Service;

import com.example.portfolio.Model.Admin;
import com.example.portfolio.Repository.AdminRepository;
import com.example.portfolio.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository admiRepo;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String register(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admiRepo.save(admin);
        return "Admin registered";
    }

    public String login(Admin admin) {
        Optional<Admin> optionalAdmin = admiRepo.findByUsername(admin.getUsername());
        if (optionalAdmin.isPresent()) {
            Admin savedAdmin = optionalAdmin.get();
            if (passwordEncoder.matches(admin.getPassword(), savedAdmin.getPassword())) {
                return jwtUtil.generateToken(savedAdmin.getUsername());
            }
        }
        return "Invalid credentials";
    }
}
