package com.example.portfolio.Controller;

import com.example.portfolio.Model.Contact;
import com.example.portfolio.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactService contServ;

    // ✅ POST: Save new message
    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {
        return contServ.saveContact(contact);
    }

    // ✅ GET: Get all messages (admin side)
    @GetMapping
    public List<Contact> getAllContacts() {
        return contServ.getAllContacts();
    }

    // ✅ DELETE: Delete message
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contServ.deleteContact(id);
    }
}
