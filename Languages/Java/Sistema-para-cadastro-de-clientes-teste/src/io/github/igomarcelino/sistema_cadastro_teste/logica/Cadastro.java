package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Cadastro<TIPO> {

    void salvarCliente(TIPO tipo) throws Exception;
    Optional<ListarCliente> pesquisarCliente(String cpf);
    void deletarCliente(TIPO tipo);
    List<ListarCliente> imprimirCliente() throws SQLException;
    int gerarCodigo();

}
