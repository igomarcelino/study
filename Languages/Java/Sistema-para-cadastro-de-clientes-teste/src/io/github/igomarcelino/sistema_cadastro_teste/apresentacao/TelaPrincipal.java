package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;
import io.github.igomarcelino.sistema_cadastro_teste.logica.LogicaBancoDeDados;

import javax.accessibility.AccessibleTable;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

public class TelaPrincipal extends JFrame {

    JMenuBar menuBar;
    JMenu menuCadastro;
    JMenu menuCadastroClientes;
    JMenuItem novoCliente;
    JMenuItem atualizarCliente;
    JMenuItem deletarCliente;
    JMenu menuRelatorio;
    JMenu menuRelatorioClientes;
    JMenuItem relatorioCLientes;
    JMenu sair;

    public TelaPrincipal(){
        criarTela();
    }

    public void criarTela()  {
        menuBar();

    }

    private void menuBar() {
        // COnfdigura a menu bar
        setTitle("Cadastro Clientes");
        setSize(600,400);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuCadastro();
        menuRelatorio();
        menuSair();
    }

    private void menuCadastro() {
        // adicionando a barra de menu
        menuCadastro = new JMenu("Cadastro");
        menuBar.add(menuCadastro);
        // menu clientes
        menuCadastroClientes = new JMenu("Cliente");
        menuCadastro.add(menuCadastroClientes);
        // adicionar cliente
        novoCliente = new JMenuItem("Novo");
        // atualizar cliente
        atualizarCliente = new JMenuItem("Atualizar");
        // deletar clieten
        deletarCliente = new JMenuItem("Deletar");
        //adicionar itens ao menu
        menuCadastroClientes.add(novoCliente);
        menuCadastroClientes.add(atualizarCliente);
        menuCadastroClientes.add(deletarCliente);
        // Menu contas

        // actionerListener
        novoCliente.addActionListener(novoCliente());
        atualizarCliente.addActionListener(atualizarCliente());
        deletarCliente.addActionListener(deletarCliente());
    }

    public void menuRelatorio(){
        // adicionar menu relatorios
        menuRelatorio = new JMenu("Relatorios");
        menuBar.add(menuRelatorio);
        // adiciona subitens ao menu relatorio
        menuRelatorioClientes = new JMenu("Relatorio Clientes");
        menuRelatorio.add(menuRelatorioClientes);
        relatorioCLientes = new JMenuItem("Listar Clientes");
        menuRelatorioClientes.add(relatorioCLientes);
        // teste de list
        relatorioCLientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexao conexao = new Conexao();
                LogicaBancoDeDados logicaBancoDeDados = new LogicaBancoDeDados(new ClienteDAO(conexao.criarConexao()));
                List<ListarCliente> listaDeClientes = logicaBancoDeDados.imprimirCliente();
                String[] colunas = {"Codigo", "Nome", "Sexo", "Data de Nascimento"};
                Object[][] data  = new Object[listaDeClientes.size()][colunas.length];
                for(int i = 0; i < listaDeClientes.size(); i++){
                    data[i][0] = listaDeClientes.get(i).getCodigo();
                    data[i][1] = listaDeClientes.get(i).getNome();
                    data[i][2] = listaDeClientes.get(i).getSexo();
                    data[i][3] = listaDeClientes.get(i).getDataNascimento();
                }
                JTable tabelaClientes = new JTable(data,colunas).getTableHeader().getTable();

                var telaTabela = new JFrame("Lista de Clientes");
                telaTabela.setSize(400,200);
                telaTabela.add(new JScrollPane(tabelaClientes));
                telaTabela.setVisible(true);
                telaTabela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            }
        });



    }

    public void menuSair(){
        sair = new JMenu("Sair");
        menuBar.add(sair);
        JMenuItem itemSair = new JMenuItem("Sair");
        sair.add(itemSair);

    }

    // ACTIONListener
    public ActionListener novoCliente(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.setVisible(true);
            }
        };
    }

    public ActionListener atualizarCliente(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAtualizar telaAtualizar = new TelaAtualizar();
                telaAtualizar.setVisible(true);
            }
        };
    }

    public ActionListener deletarCliente(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDeletarCliente telaDeletarCliente = new TelaDeletarCliente();
                telaDeletarCliente.setVisible(true);
            }
        };
    }

}
