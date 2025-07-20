package com.example.portfolio.Controller;

import com.example.portfolio.Model.Admin;
import com.example.portfolio.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private AdminService admiServ;

    @PostMapping("/register")
    public String register(@RequestBody Admin admin) {
        return admiServ.register(admin);
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {
        return admiServ.login(admin);
    }
}
