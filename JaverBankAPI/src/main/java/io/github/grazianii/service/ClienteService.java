package io.github.grazianii.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ClienteService {
    public float calcularScoreCredito(float saldo_cc){
        return saldo_cc * 0.1f;
    }
}
