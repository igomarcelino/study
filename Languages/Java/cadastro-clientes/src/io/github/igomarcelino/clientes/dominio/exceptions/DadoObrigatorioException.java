package io.github.igomarcelino.clientes.dominio.exceptions;

public class DadoObrigatorioException extends RuntimeException{
    public DadoObrigatorioException(String message) {// construtor que permite mensagem personalizada
        super(message);
    }
}
