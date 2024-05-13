package io.github.igomarcelino.clientes.dominio.exceptions;

import java.util.concurrent.ExecutionException;

public class SexoinvalidoException extends RuntimeException {
    public SexoinvalidoException(String message) { // construtor que permite mensagem personalizada
        super(message);
    }
}
