package io.github.grazianii.exception;

public class ContaCorrenteNaoEncontradaException extends RuntimeException {

    public ContaCorrenteNaoEncontradaException() {
        super("Conta corrente não encontrada.");
    }
}