package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.EstadosBrasileiros;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo;
import io.github.igomarcelino.sistema_cadastro_teste.logica.BancoDeDadosFake;
import io.github.igomarcelino.sistema_cadastro_teste.logica.Cadastro;

import javax.accessibility.AccessibleRelation;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo.M;

public class TelaCadastro extends JFrame {

    private JLabel labelNome;
    private JTextField textNome;
    private JLabel labelCPF;
    private JTextField textCPF;

    private JLabel labelSexo;
    private JComboBox<TipoSexo> comboBoxTipoSexo;
    private JLabel labelDataNascimento;
    private JTextField textDataNascimento;

    private JLabel labelEndereco;

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
    private JButton btnSalvar;
    private JButton btnFechar;

    private Cadastro<Cliente> bancoMemoria;

    // construtor
    public TelaCadastro() {

        bancoMemoria = new BancoDeDadosFake();
        construirTela();
    }

    // metodos
    public void construirTela(){

        setSize(600,600);
        setTitle("Cadastro de Clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adicionarCampos();
        adicionarBotao();
    }

    public void adicionarCampos(){

        labelNome = new JLabel("Nome: ");
        labelNome.setBounds(20,20,60,20);
        getContentPane().add(labelNome);
        textNome = new JTextField();
        textNome.setBounds(70,20,400,20);
        getContentPane().add(textNome);

        labelCPF = new JLabel("CPF: ");
        labelCPF.setBounds(20,60,60,20);
        getContentPane().add(labelCPF);
        textCPF = new JTextField();
        textCPF.setBounds(70,60,100,20);
        getContentPane().add(textCPF);

         labelSexo = new JLabel("sexo: ");
         labelSexo.setBounds(20,100,60,20);
         getContentPane().add(labelSexo);
         TipoSexo[] tipoSexo = {null, M,TipoSexo.F,TipoSexo.O};  // JCOmbobox pede um array para mostrar seus campos
         comboBoxTipoSexo = new JComboBox<TipoSexo>(tipoSexo);
         comboBoxTipoSexo.setBounds(70,100,50,20);
         getContentPane().add(comboBoxTipoSexo);

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

      /*  // Endereco

        labelEndereco = new JLabel(" --------------------------- Endereco ------------------------------");
        labelEndereco.setBounds(20,160,100,20);
        getContentPane().add(labelEndereco);*/


        labelRua = new JLabel("rua: ");
        labelRua.setBounds(20,180,60,20);
        getContentPane().add(labelRua);
        textRua = new JTextField();
        textRua.setBounds(55,180,400,20);
        getContentPane().add(textRua);

        labelNumeroCasa = new JLabel("numero: ");
        labelNumeroCasa.setBounds(20,220,80,20);
        getContentPane().add(labelNumeroCasa);
        textNumerocasa = new JTextField();
        textNumerocasa.setBounds(80,220,50,20);
        getContentPane().add(textNumerocasa);

        labelBairro = new JLabel("bairro: ");
        labelBairro.setBounds(20,260,60,20);
        getContentPane().add(labelBairro);
        textBairro = new JTextField();
        textBairro.setBounds(70,260,200,20);
        getContentPane().add(textBairro);


        labelCidade = new JLabel("cidade: ");
        labelCidade.setBounds(20,300,60,20);
        getContentPane().add(labelCidade);
        textCidade = new JTextField();
        textCidade.setBounds(80,300,200,20);
        getContentPane().add(textCidade);

        labelEstado = new JLabel("estado: ");
        labelEstado.setBounds(20,340,60,20);
        getContentPane().add(labelEstado);
        comboBoxEstado = new JComboBox<EstadosBrasileiros>(EstadosBrasileiros.values());
        comboBoxEstado.setBounds(80,340,50,20);
        getContentPane().add(comboBoxEstado);

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

    public void adicionarBotao(){

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20,420,80,20);
        getContentPane().add(btnSalvar);

        ActionListener botaoSalvar = this.salvarCliente();
        btnSalvar.addActionListener(botaoSalvar);

        btnFechar = new JButton("Fechar");
        btnFechar.setBounds(110,420,90,20);
        getContentPane().add(btnFechar);

        ActionListener botaoFechar = this.fecharJanela();
        btnFechar.addActionListener(botaoFechar);


    }

    public ActionListener salvarCliente(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNome(textNome.getText());
                cliente.setCPF(textCPF.getText());
                cliente.setTipoSexo((TipoSexo) comboBoxTipoSexo.getSelectedItem());
                cliente.setDataNascimento(textDataNascimento.getText());
                cliente.setRua(textRua.getText());
                cliente.setNumero(textNumerocasa.getText());
                cliente.setBairro(textBairro.getText());
                cliente.setCidade(textCidade.getText());
                cliente.setEstado((EstadosBrasileiros) comboBoxEstado.getSelectedItem());
                cliente.setTelefone(textTelefone.getText());

                bancoMemoria.salvarCliente(cliente);
                bancoMemoria.imprimirCliente(cliente);
                limparCampos();


            }
        };
    }

    public void limparCampos() {
        textNome.setText(null);
        textCPF.setText(null);
        comboBoxTipoSexo.setSelectedItem(null);
        textDataNascimento.setText(null);
        textRua.setText(null);
        textNumerocasa.setText(null);
        textBairro.setText(null);
        textCidade.setText(null);
        comboBoxEstado.setSelectedItem(null);
        textTelefone.setText(null);

    }

    public ActionListener fecharJanela(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        };
    }
}



