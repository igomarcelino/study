package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;
import io.github.igomarcelino.sistema_cadastro_teste.logica.Cadastro;
import io.github.igomarcelino.sistema_cadastro_teste.logica.LogicaBancoDeDados;

import javax.swing.*;

public class TelaAtualizar extends JFrame {

    private JLabel labelCliente;
    private JTextField textCliente;

    public TelaAtualizar(){
        var conexao = Conexao.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        var bancoDeDados = new LogicaBancoDeDados(clienteDAO);
        construirTela();
    }

    public void construirTela() {

        setSize(600, 600);
        setTitle("Cadastro de Clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    //adicionar botoes
    //adicionar acoes
}
