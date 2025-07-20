package com.example.portfolio.Service;

import com.example.portfolio.Model.Client;
import com.example.portfolio.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository cliRepo;

    public List<Client> getAllClients() {
        return cliRepo.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return cliRepo.findById(id);
    }

    public Client createClient(Client client) {
        return cliRepo.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        return cliRepo.findById(id).map(client -> {
            client.setName(updatedClient.getName());
            client.setCompany(updatedClient.getCompany());
            client.setImageUrl(updatedClient.getImageUrl());
            client.setTestimonial(updatedClient.getTestimonial());
            return cliRepo.save(client);
        }).orElseGet(() -> {
            updatedClient.setId(id);
            return cliRepo.save(updatedClient);
        });
    }

    public void deleteClient(Long id) {
        cliRepo.deleteById(id);
    }
}
