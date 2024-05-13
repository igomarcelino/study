package io.github.igomarcelino.clientes.logicanegocio;

import io.github.igomarcelino.clientes.dominio.Cliente;

import java.util.UUID;

public class LogicaFake implements Cadastro<Cliente> {
    @Override
    public void salvar(Cliente cliente) {


    }

    @Override
    public Cliente buscar(UUID codigo) {
        return null;
    }

    @Override
    public void deletar(UUID codigo) {

    }

    @Override
    public void atualizar(Cliente cliente) {

    }
}
