package io.github.grazianii.service;

import io.github.grazianii.domain.entity.Cliente;
import io.github.grazianii.domain.entity.ContaCorrente;
import io.github.grazianii.domain.repository.Clientes;
import io.github.grazianii.domain.repository.ContasCorrentes;
import io.github.grazianii.domain.rest.dto.ContaCorrenteDTO;
import io.github.grazianii.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContaCorrenteService {

    private final Clientes clientesRepository;
    private final ContasCorrentes contasCorrentesRepository;

    @Transactional
    public ContaCorrente save (ContaCorrenteDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido. "));

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setCliente(cliente);
        contaCorrente.setSaldo_cc(dto.getSaldo());
        contasCorrentesRepository.save(contaCorrente);
        return contaCorrente;
    }
}
