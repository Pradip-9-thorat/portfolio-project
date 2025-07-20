package com.example.portfolio.Repository;

import com.example.portfolio.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
