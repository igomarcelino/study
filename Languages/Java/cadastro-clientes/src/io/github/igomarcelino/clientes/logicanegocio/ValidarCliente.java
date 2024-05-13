package io.github.igomarcelino.clientes.logicanegocio;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.dominio.exceptions.DadoObrigatorioException;

public class ValidarCliente {

    public static void validarCliente(Cliente cliente) throws CpfInvalidoException { // classe o qual esta herdando a exception
        if(cliente.getCpf().length() != 11){
            throw  new CpfInvalidoException("Cpf invalido."); // exception a ser lancada
        }
        nomeNulo(cliente);
        sexoNulo(cliente);
    }

    static void nomeNulo(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            throw new DadoObrigatorioException("Nome invalido");
        }
    }

    static void sexoNulo(Cliente cliente){
        if (cliente.getSexo() == null){
            throw new DadoObrigatorioException("Campo sexo obrigatorio");
        }
    }
}
