package io.github.grazianii.service;

import io.github.grazianii.domain.entity.Cliente;
import io.github.grazianii.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        cliente.setScore_credito(cliente.getSaldo_cc() * 0.1f);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Integer id, Cliente cliente) {
        cliente.setId(id);
        cliente.setScore_credito(cliente.getSaldo_cc() * 0.1f);
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }
}