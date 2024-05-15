package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Exceptions.CpfValidoException;

public interface Cadastro<TIPO> {

    void salvarCliente(TIPO tipo) throws Exception;
    void pesquisarCliente(TIPO tipo);
    void deletarCliente(TIPO tipo);
    void imprimirCliente(TIPO tipo);

}
