package io.github.grazianii.domain.repository;

import io.github.grazianii.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    @Query (value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> findByNome(@Param("nome") String nome);

    @Modifying
    @Query (" delete from Cliente c where c.nome =:nome ")
    void deleteByNome(@Param("nome") String nome);
    }