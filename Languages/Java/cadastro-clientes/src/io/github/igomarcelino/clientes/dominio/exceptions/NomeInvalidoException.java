package io.github.igomarcelino.clientes.dominio.exceptions;

public class NomeInvalidoException extends RuntimeException{
    public NomeInvalidoException(String message) {
        super(message);
    }
}
