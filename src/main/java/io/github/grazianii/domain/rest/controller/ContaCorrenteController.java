package io.github.grazianii.domain.rest.controller;


import io.github.grazianii.domain.entity.Cliente;
import io.github.grazianii.domain.entity.ContaCorrente;
import io.github.grazianii.domain.repository.ContasCorrentes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping ("/api/contascorrentes")
public class ContaCorrenteController {

    private ContasCorrentes repository;

    public ContaCorrenteController(ContasCorrentes repository) {
        this.repository = repository;
    }

    // Efetuar o select no banco de dados para localizar uma conta corrente, buscando pelo id
    @GetMapping("{id}")
    public ContaCorrente getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Conta-corrente não localizada.")
                );
    }

    // Persiste uma conta corrente no banco de dados
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaCorrente save(@RequestBody ContaCorrente contaCorrente) {
        return repository.save(contaCorrente);
    }

    // Deletar uma conta corrente do banco de dados
    @DeleteMapping({"id"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        repository.findById(id)
                .map(conta -> {
                    repository.delete(conta);
                    return conta;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta corrente não encontrada."));
    }

    // Atualizar uma conta corrente existente no banco de dados
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody ContaCorrente contaCorrente) {
        repository.findById(id)
                .map(contaUpdated -> {
                    contaCorrente.setId(contaUpdated.getId());
                    repository.save(contaCorrente);
                    return contaUpdated;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta corrente não encontrada."));
    }
}