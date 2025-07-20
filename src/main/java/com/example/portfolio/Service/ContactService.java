package com.example.portfolio.Service;

import com.example.portfolio.Model.Contact;
import com.example.portfolio.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contRepo;

    public List<Contact> getAllContacts() {
        return contRepo.findAll();
    }

    public Contact saveContact(Contact contact) {
        return contRepo.save(contact);
    }

    public void deleteContact(Long id) {
        contRepo.deleteById(id);
    }
}
