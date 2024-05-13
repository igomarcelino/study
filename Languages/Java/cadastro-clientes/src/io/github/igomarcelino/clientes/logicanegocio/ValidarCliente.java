package io.github.igomarcelino.clientes.logicanegocio;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.dominio.exceptions.NomeInvalidoException;

public class ValidarCliente {

    public static void validarCliente(Cliente cliente) throws CpfInvalidoException { // classe o qual esta herdando a exception
        if(cliente.getCpf().length() != 11){
            throw  new CpfInvalidoException("Cpf invalido."); // exception a ser lancada
        }

        nomeNulo(cliente);
    }

    static void nomeNulo(Cliente cliente){
        if(cliente.getNome() == null){
            throw new NomeInvalidoException("Nome invalido");
        }
    }
}
