package io.github.grazianii.controller;

import io.github.grazianii.dto.ClienteDTO;
import io.github.grazianii.feign.ClienteClient;
import io.github.grazianii.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    @Operation(summary = "Busca cliente no banco de dados", description = "Busca um cliente no banco de dados pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ClienteDTO getClienteById(@PathVariable Integer id) {
        return clienteClient.findClienteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Salva cliente no banco de dados", description = "Salva um cliente pelo no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente salvo com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ClienteDTO save(@RequestBody ClienteDTO clienteDTO) {
        return clienteClient.save(clienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deleta um cliente no banco de dados", description = "Deleta um cliente no banco de dados, buscando pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public void delete(@PathVariable Integer id) {
        clienteClient.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Atualiza um cliente", description = "Atualiza um cliente no banco de dados, buscando pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public void update(@PathVariable Integer id, @RequestBody ClienteDTO clienteDTO) {
        clienteClient.update(id, clienteDTO);
    }

    @GetMapping
    @Operation(summary = "Busca lista de clientes no banco de dados", description = "Busca uma lista de clientes no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clientes encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Clientes não encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public List<ClienteDTO> findClienteList() {
        return clienteClient.findClienteList();
    }

    @GetMapping("/{id}/score")
    @Operation(summary = "Retorna score de um cliente no banco de dados", description = "Retorna o score um cliente no banco de dados, buscando pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Score de cliente localizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Score de cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<Float> getScoreCredito(@PathVariable("id") Integer id) {
        ClienteDTO cliente = clienteClient.findClienteById(id);
        float scoreCredito = service.calcularScoreCredito(cliente.getSaldo_cc());
        return ResponseEntity.ok(scoreCredito);
    }
}
