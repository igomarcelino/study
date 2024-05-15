package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDadosFake implements Cadastro<Cliente> {

    private List<Cliente> cliente;

    public BancoDeDadosFake() {
        this.cliente = new ArrayList<>();
    }

    @Override
    public void salvarCliente(Cliente cliente) {

        this.cliente.add(cliente);
    }

    @Override
    public void pesquisarCliente(Cliente cliente) {

    }

    @Override
    public void deletarCliente(Cliente cliente) {

    }

    @Override
    public void imprimirCliente(Cliente cliente) {

        System.out.println(cliente);

    }
}
