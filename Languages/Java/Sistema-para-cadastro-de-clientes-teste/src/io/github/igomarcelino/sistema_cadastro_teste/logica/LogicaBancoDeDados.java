package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.BuscaCliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class LogicaBancoDeDados implements Cadastro<Cliente>   {

    ClienteDAO clienteDAO;

    public LogicaBancoDeDados(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void salvarCliente(Cliente cliente) throws Exception {
            ValidaCliente.validarCliente(cliente);
            clienteDAO.inserirCLiente(cliente);
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

    }


    @Override
    public void deletarCliente(String cpf) {
        if(clienteDAO.procurarCliente(cpf).isPresent()){
            clienteDAO.deletarCliente(cpf);
            JOptionPane.showMessageDialog(null,"Cliente Deletado");
        }else {
            JOptionPane.showMessageDialog(null,"Cliente nao encontrado");
        }
    }

    @Override
    public List<ListarCliente> imprimirCliente() {
        return clienteDAO.listarClientes();
    }

    @Override
    public Optional<BuscaCliente> pesquisarCliente(String cpf) {

        return clienteDAO.procurarCliente(cpf).or(() -> Optional.empty());
    }

    @Override
    public void atualizarCliente(BuscaCliente cliente) {
        clienteDAO.atualizarClientes(cliente);
        JOptionPane.showMessageDialog(null,"Cliente Atualizado");
    }

    public  int gerarCodigo(){

        int codigoAtual = clienteDAO.contarRegistros() ;
        return codigoAtual;
    }
}
