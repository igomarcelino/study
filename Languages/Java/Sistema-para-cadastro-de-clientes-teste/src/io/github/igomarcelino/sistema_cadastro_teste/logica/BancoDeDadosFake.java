package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Exceptions.CpfValidoException;
import io.github.igomarcelino.sistema_cadastro_teste.utilitarios.ConverterFotoParaArray;
import io.github.igomarcelino.sistema_cadastro_teste.utilitarios.PersistenciaDeFoto;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;
import java.util.List;

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
