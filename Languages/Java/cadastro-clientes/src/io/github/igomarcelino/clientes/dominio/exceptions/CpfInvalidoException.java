package io.github.igomarcelino.clientes.dominio.exceptions;

public class CpfInvalidoException extends Exception{

    public CpfInvalidoException(String message) { // construtor que permite mensagem personalizada
        super(message);
    }
}

