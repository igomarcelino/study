package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Exceptions.CpfValidoException;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;
import io.github.igomarcelino.sistema_cadastro_teste.utilitarios.PersistenciaDeFoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BancoDeDadosFake implements Cadastro<Cliente> {

    private List<Cliente> cliente;

    public BancoDeDadosFake() {


        this.cliente = new ArrayList<>();
    }

    @Override
    public void salvarCliente(Cliente cliente) throws CpfValidoException {

        ValidaCliente.validarCliente(cliente);
        this.cliente.add(cliente);
        PersistenciaDeFoto.persistirFotos(cliente.getNome()+".jpg",cliente.getFotoArray());
    }

    @Override
    public Optional<ListarCliente> pesquisarCliente(String cpf) {
        return Optional.empty();
    }

    @Override
    public void deletarCliente(Cliente cliente) {

    }

    @Override
    public List<ListarCliente> imprimirCliente( ) {

        return null;

    }

    @Override
    public int gerarCodigo() {
        return 0;
    }
}
