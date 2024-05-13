package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import javax.swing.*;

public class TelaCadastro extends JFrame {

    private JLabel labelNome;
    private JLabel labelCPF;
    private JLabel labelSexo;
    private JLabel labelDataNascimento;
    private JLabel labelRua;
    private JLabel labelNumeroCasa;
    private JLabel labelBairro;
    private JLabel labelCidade;
    private JLabel labelEstado;
    private JLabel labelTelefone;
    public TelaCadastro() {
        construirTela();
    }

    public void construirTela(){

        setSize(600,600);
        setTitle("Cadastro de Clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adicionarCampos();
    }

    public void adicionarCampos(){

        labelNome = new JLabel("Nome: ");
        labelNome.setBounds(20,20,60,20);
        getContentPane().add(labelNome);

        labelCPF = new JLabel("CPF: ");
        labelCPF.setBounds(20,60,60,20);
        getContentPane().add(labelCPF);

         labelSexo = new JLabel("sexo: ");
         labelSexo.setBounds(20,100,60,20);
         getContentPane().add(labelSexo);

        labelDataNascimento = new JLabel("data de nascimento: ");
        labelDataNascimento.setBounds(20,140,180,20);
        getContentPane().add(labelDataNascimento);

        labelRua = new JLabel("rua: ");
        labelRua.setBounds(20,180,60,20);
        getContentPane().add(labelRua);

        labelNumeroCasa = new JLabel("numero: ");
        labelNumeroCasa.setBounds(20,220,80,20);
        getContentPane().add(labelNumeroCasa);

        labelBairro = new JLabel("bairro: ");
        labelBairro.setBounds(20,260,60,20);
        getContentPane().add(labelBairro);

        labelCidade = new JLabel("cidade: ");
        labelCidade.setBounds(20,300,60,20);
        getContentPane().add(labelCidade);

        labelEstado = new JLabel("estado: ");
        labelEstado.setBounds(20,340,60,20);
        getContentPane().add(labelEstado);

        labelTelefone = new JLabel("telefone: ");
        labelTelefone.setBounds(20,400,100,20);
        getContentPane().add(labelTelefone);

    }
}
