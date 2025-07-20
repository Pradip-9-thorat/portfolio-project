package com.example.portfolio.Controller;

import com.example.portfolio.Model.Client;
import com.example.portfolio.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {

    @Autowired
    private ClientService cliServ;

    @GetMapping
    public List<Client> getAllClients() {
        return cliServ.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return cliServ.getClientById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return cliServ.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return cliServ.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        cliServ.deleteClient(id);
    }
}
