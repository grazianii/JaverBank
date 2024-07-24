package io.github.grazianii.domain.rest.controller;

import io.github.grazianii.domain.repository.Clientes;
import io.github.grazianii.domain.entity.Cliente;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController (Clientes clientes){
        this.clientes = clientes;
    }

    // Efetuar o select no banco de dados para localizar um cliente, buscando pelo id
    @GetMapping("{id}")
    public Cliente getClienteById (@PathVariable Integer id){
        return clientes.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    // Persiste um cliente no banco de dados
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente){
        return clientes.save(cliente);
    }

    // Deletar um cliente do banco de dados
    @DeleteMapping({"id"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete (@PathVariable Integer id){
        clientes.findById(id)
                .map( cliente -> {
                    clientes.delete(cliente);
                    return cliente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    // Atualizar um cliente existente no banco de dados
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable Integer id, @RequestBody Cliente cliente){
        clientes.findById(id)
                .map(clienteUpdated -> {
                    cliente.setId(clienteUpdated.getId());
                    clientes.save(cliente);
                    return clienteUpdated;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    // Efetuar o select de uma lista de clientes no banco de dados, buscando pelo nome
    @GetMapping
    public List<Cliente> findClienteList (Cliente cliente){
        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cliente> example = Example.of(cliente,exampleMatcher);
        return clientes.findAll(example);
    }
}
