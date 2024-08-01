package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.BuscaCliente;
import io.github.igomarcelino.sistema_cadastro_teste.logica.LogicaBancoDeDados;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Optional;

public class TelaDeletarCliente extends JFrame {
    private JLabel labelCliente;
    private JTextField textPesquisarCliente;
    private JButton btnPesquisar;

    private JLabel labelNome;
    private JTextField textNome;
    private JLabel labelCPF;
    private JTextField textCPF;
    private JLabel labelDataNascimento;
    private JTextField textDataNascimento;
    private JLabel labelRua;
    private JTextField textRua;
    private JLabel labelNumeroCasa;
    private JTextField textNumerocasa;
    private JLabel labelBairro;
    private JTextField textBairro;
    private JLabel labelCidade;
    private JTextField textCidade;
    private JLabel labelEstado;
    private JTextField textEstado;
    private JLabel labelTelefone;
    private JTextField textTelefone;
    private JButton btnDeletar;
    private JButton btnSair;
    private LogicaBancoDeDados bancoDeDados;

    public TelaDeletarCliente() {
        var conexao = Conexao.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        bancoDeDados = new LogicaBancoDeDados(clienteDAO);
        construirTela();
    }

    public void construirTela(){
        setSize(600,600);
        setTitle("Deletar Cliente");
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        adicionaCampos();
        adicionaBotoes();
    }

    //adicionar campos
    public void adicionaCampos(){

        // campo pesquisar
        labelCliente = new JLabel("CPF do cliente: ");
        labelCliente.setBounds(20,20,150,20);
        getContentPane().add(labelCliente);

        textPesquisarCliente = new JTextField();
        textPesquisarCliente.setBounds(140,20,150,20);
        getContentPane().add(textPesquisarCliente);


        // campo nome
        labelNome = new JLabel("Nome: ");
        labelNome.setBounds(20,60,60,20);
        getContentPane().add(labelNome);
        textNome = new JTextField();
        textNome.setBounds(70,60,400,20);
        getContentPane().add(textNome);
        textNome.setEditable(false);


        // campo cpf
        labelCPF = new JLabel("CPF: ");
        labelCPF.setBounds(20,100,60,20);
        getContentPane().add(labelCPF);
        textCPF = new JTextField();
        textCPF.setBounds(70,100,100,20);
        getContentPane().add(textCPF);
        textCPF.setEditable(false);

        //campo data nascimento
        labelDataNascimento = new JLabel("d. nascimento: ");
        labelDataNascimento.setBounds(20,140,170,20);
        getContentPane().add(labelDataNascimento);
        MaskFormatter dataFormater;
        try {
            dataFormater = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        textDataNascimento = new JFormattedTextField(dataFormater);
        textDataNascimento.setBounds(130,140,100,20);
        getContentPane().add(textDataNascimento);
        textDataNascimento.setEditable(false);


        // campo rua
        labelRua = new JLabel("rua: ");
        labelRua.setBounds(20,180,60,20);
        getContentPane().add(labelRua);
        textRua = new JTextField();
        textRua.setBounds(55,180,400,20);
        getContentPane().add(textRua);
        textRua.setEditable(false);


        //campo numero
        labelNumeroCasa = new JLabel("numero: ");
        labelNumeroCasa.setBounds(20,220,80,20);
        getContentPane().add(labelNumeroCasa);
        textNumerocasa = new JTextField();
        textNumerocasa.setBounds(80,220,50,20);
        getContentPane().add(textNumerocasa);
        textNumerocasa.setEditable(false);


        // campo bairro
        labelBairro = new JLabel("bairro: ");
        labelBairro.setBounds(20,260,60,20);
        getContentPane().add(labelBairro);
        textBairro = new JTextField();
        textBairro.setBounds(70,260,200,20);
        getContentPane().add(textBairro);
        textBairro.setEditable(false);


        //campo cidade
        labelCidade = new JLabel("cidade: ");
        labelCidade.setBounds(20,300,60,20);
        getContentPane().add(labelCidade);
        textCidade = new JTextField();
        textCidade.setBounds(80,300,200,20);
        getContentPane().add(textCidade);
        textCidade.setEditable(false);

        //campo estado
        labelEstado = new JLabel("estado: ");
        labelEstado.setBounds(20,340,60,20);
        getContentPane().add(labelEstado);
        textEstado = new JTextField();
        textEstado.setBounds(80,340,50,20);
        getContentPane().add(textEstado);
        textEstado.setEditable(false);

        //campo telefone
        labelTelefone = new JLabel("telefone: ");
        labelTelefone.setBounds(20,380,100,20);
        getContentPane().add(labelTelefone);

        MaskFormatter telefoneFormat ;
        try {
            telefoneFormat = new MaskFormatter("(##) #####-####");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        textTelefone = new JFormattedTextField(telefoneFormat);
        textTelefone.setBounds(90,380,120,20);
        getContentPane().add(textTelefone);
        textTelefone.setEditable(false);


    }

    //adicionar botoes

    public void adicionaBotoes(){
        // btn pesquisar
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(300,20,130,20);
        getContentPane().add(btnPesquisar);
        btnPesquisar.addActionListener(pesquisar());

        // btn deletar
        btnDeletar = new JButton("Deletar");
        btnDeletar.setBounds(240,480,90,20);
        getContentPane().add(btnDeletar);
        btnDeletar.addActionListener(deletarCliente());

        //btn sair
        btnSair = new JButton("Sair");
        btnSair.setBounds(350,480,80,20);
        getContentPane().add(btnSair);
        btnSair.addActionListener(sair());
    }

    //acoes

    public ActionListener pesquisar(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = textPesquisarCliente.getText();
                Optional<BuscaCliente> clienteEncontrado = bancoDeDados.pesquisarCliente(nomeCliente);
                System.out.println(clienteEncontrado);
                if (clienteEncontrado.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Cliente nao encontrado");
                }else {
                    textNome.setText(clienteEncontrado.get().getNome());
                    textCPF.setText(clienteEncontrado.get().getCPF());
                    textDataNascimento.setText(clienteEncontrado.get().getDataNascimento());
                    textRua.setText(clienteEncontrado.get().getRua());
                    textNumerocasa.setText(clienteEncontrado.get().getNumero());
                    textBairro.setText(clienteEncontrado.get().getBairro());
                    textCidade.setText(clienteEncontrado.get().getCidade());
                    textEstado.setText(clienteEncontrado.get().getEstado().name());
                    textTelefone.setText(clienteEncontrado.get().getTelefone());
                }
            }
        };
    }

    public ActionListener deletarCliente(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bancoDeDados.deletarCliente(textCPF.getText());
                textPesquisarCliente.setText("");
                textNome.setText("");
                textCPF.setText("");
                textDataNascimento.setText("");
                textRua.setText("");
                textNumerocasa.setText("");
                textBairro.setText("");
                textCidade.setText("");
                textEstado.setText("");
                textTelefone.setText("");
            }
        };
    }

    public ActionListener sair(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaDeletarCliente.this.dispose();
            }
        };
    }

}
