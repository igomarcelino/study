package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.EstadosBrasileiros;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Calendar;

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
    public TelaCadastro() {

        construirTela();
    }

    public void construirTela(){

        setSize(600,600);
        setTitle("Cadastro de Clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        MaskFormatter dataFormat;



        adicionarCampos();
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
         comboBoxTipoSexo = new JComboBox<TipoSexo>(TipoSexo.values());
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
}
