package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.BuscaCliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.EstadosBrasileiros;
import io.github.igomarcelino.sistema_cadastro_teste.logica.Cadastro;
import io.github.igomarcelino.sistema_cadastro_teste.logica.LogicaBancoDeDados;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Optional;

public class TelaAtualizar extends JFrame {

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
    private JComboBox<EstadosBrasileiros> comboBoxEstado;
    private JLabel labelTelefone;
    private JTextField textTelefone;
    private JButton btnAlterar;
    private JButton btnSair;
    private LogicaBancoDeDados bancoDeDados;


    public TelaAtualizar(){
        var conexao = Conexao.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        bancoDeDados = new LogicaBancoDeDados(clienteDAO);
        construirTela();
    }

    public void construirTela() {

        setSize(600, 600);
        setTitle("Atualizar Clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        adicionaCampos();
        adicionaBotoes();
    }

    //adicionar botoes
    public void adicionaCampos(){

        // campo pesquisar
        labelCliente = new JLabel("Nome do cliente: ");
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

        // campo cpf
        labelCPF = new JLabel("CPF: ");
        labelCPF.setBounds(20,100,60,20);
        getContentPane().add(labelCPF);
        textCPF = new JTextField();
        textCPF.setBounds(70,100,100,20);
        getContentPane().add(textCPF);

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

        // campo rua
        labelRua = new JLabel("rua: ");
        labelRua.setBounds(20,180,60,20);
        getContentPane().add(labelRua);
        textRua = new JTextField();
        textRua.setBounds(55,180,400,20);
        getContentPane().add(textRua);

        //campo numero
        labelNumeroCasa = new JLabel("numero: ");
        labelNumeroCasa.setBounds(20,220,80,20);
        getContentPane().add(labelNumeroCasa);
        textNumerocasa = new JTextField();
        textNumerocasa.setBounds(80,220,50,20);
        getContentPane().add(textNumerocasa);

        // campo bairro
        labelBairro = new JLabel("bairro: ");
        labelBairro.setBounds(20,260,60,20);
        getContentPane().add(labelBairro);
        textBairro = new JTextField();
        textBairro.setBounds(70,260,200,20);
        getContentPane().add(textBairro);

        //campo cidade
        labelCidade = new JLabel("cidade: ");
        labelCidade.setBounds(20,300,60,20);
        getContentPane().add(labelCidade);
        textCidade = new JTextField();
        textCidade.setBounds(80,300,200,20);
        getContentPane().add(textCidade);

        //campo estado
        labelEstado = new JLabel("estado: ");
        labelEstado.setBounds(20,340,60,20);
        getContentPane().add(labelEstado);
        comboBoxEstado = new JComboBox<EstadosBrasileiros>(EstadosBrasileiros.values());
        comboBoxEstado.setBounds(80,340,50,20);
        getContentPane().add(comboBoxEstado);

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


    }

    public void adicionaBotoes(){

        // btn pesquisar
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setBounds(300,20,130,20);
        getContentPane().add(btnPesquisar);
        btnPesquisar.addActionListener(pesquisar());

        //btn alterar
        btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(240,480,90,20);
        getContentPane().add(btnAlterar);
        btnAlterar.addActionListener(atualizarCliente());

        //btn sair
        btnSair = new JButton("Sair");
        btnSair.setBounds(350,480,80,20);
        getContentPane().add(btnSair);
        btnSair.addActionListener(sair());
    }
    //adicionar acoes

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
                    textCPF.setEditable(false);
                    textDataNascimento.setText(clienteEncontrado.get().getDataNascimento());
                    textRua.setText(clienteEncontrado.get().getRua());
                    textNumerocasa.setText(clienteEncontrado.get().getNumero());
                    textBairro.setText(clienteEncontrado.get().getBairro());
                    textCidade.setText(clienteEncontrado.get().getCidade());
                    textTelefone.setText(clienteEncontrado.get().getTelefone());
                }
            }
        };
    }

    public ActionListener atualizarCliente(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscaCliente clienteParaAtualizar = new BuscaCliente();
                clienteParaAtualizar.setCPF(textCPF.getText());
                clienteParaAtualizar.setNome(textNome.getText());
                clienteParaAtualizar.setDataNascimento(textDataNascimento.getText());
                clienteParaAtualizar.setRua(textRua.getText());
                clienteParaAtualizar.setNumero(textNumerocasa.getText());
                clienteParaAtualizar.setBairro(textBairro.getText());
                clienteParaAtualizar.setCidade(textCidade.getText());
                clienteParaAtualizar.setEstado((EstadosBrasileiros) comboBoxEstado.getSelectedItem());
                clienteParaAtualizar.setTelefone(textTelefone.getText());

                System.out.println(clienteParaAtualizar);
                bancoDeDados.atualizarCliente(clienteParaAtualizar);

                textPesquisarCliente.setText("");
                textNome.setText("");
                textCPF.setText("");
                textDataNascimento.setText("");
                textRua.setText("");
                textNumerocasa.setText("");
                textBairro.setText("");
                textCidade.setText("");
                comboBoxEstado.setSelectedItem(null);
                textTelefone.setText("");



            }
        };
    }

    public ActionListener sair(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAtualizar.this.dispose();
            }
        };
    }
}
