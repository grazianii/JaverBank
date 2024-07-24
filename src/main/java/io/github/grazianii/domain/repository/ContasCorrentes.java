package io.github.grazianii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.grazianii.domain.entity.Cliente;
import io.github.grazianii.domain.entity.ContaCorrente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContasCorrentes extends JpaRepository <ContaCorrente, Integer> {

    List<ContaCorrente> findByCliente (Cliente cliente);

    ContaCorrente findById (ContaCorrente id);
}