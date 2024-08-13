package io.github.grazianii.feign;

import io.github.grazianii.dto.ClienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "javerbank-service", url = "http://localhost:8090", path = "/clientes")
public interface ClienteClient {

    @PostMapping
    ClienteDTO save(@RequestBody ClienteDTO clienteDTO);

    @PutMapping("/{id}")
    void update(@PathVariable("id") Integer id, @RequestBody ClienteDTO clienteDTO);

    @GetMapping("/{id}")
    ClienteDTO findClienteById(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

    @GetMapping
    List<ClienteDTO> findClienteList();
}
