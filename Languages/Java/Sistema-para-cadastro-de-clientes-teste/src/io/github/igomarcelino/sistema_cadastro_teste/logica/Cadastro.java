package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Exceptions.CpfValidoException;

import java.util.Optional;

public interface Cadastro<TIPO> {

    void salvarCliente(TIPO tipo) throws Exception;
    Optional<Cliente> pesquisarCliente(TIPO tipo);
    void deletarCliente(TIPO tipo);
    void imprimirCliente(TIPO tipo);
    int gerarCodigo();

}
