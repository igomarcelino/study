package io.github.igomarcelino.clientes.logicanegocio;

import io.github.igomarcelino.clientes.dominio.Cliente;

import javax.swing.*;

public class LogicaFake implements Cadastro<Cliente> {
    @Override
    public void salvar(Cliente cliente) {


        JOptionPane.showMessageDialog(null,cliente);

    }
}
