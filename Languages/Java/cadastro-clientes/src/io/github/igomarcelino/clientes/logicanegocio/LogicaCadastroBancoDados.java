package io.github.igomarcelino.clientes.logicanegocio;

import io.github.igomarcelino.clientes.dados.ClienteDAO;
import io.github.igomarcelino.clientes.dominio.Cliente;

import javax.swing.*;
import java.util.Optional;
import java.util.UUID;

public class LogicaCadastroBancoDados implements Cadastro<Cliente> {

    private ClienteDAO clienteDAO;

    public LogicaCadastroBancoDados(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void salvar(Cliente cliente) throws Exception {
        ValidarCliente.validarCliente(cliente);
        clienteDAO.inserirCliente(cliente);
        JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!!");
    }

    @Override
    public Optional<Cliente> buscar(UUID codigo) {
        return Optional.empty();
    }

    @Override
    public void deletar(UUID codigo) {
        clienteDAO.deletarCliente(codigo);
    }

    @Override
    public void atualizar(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }
}
