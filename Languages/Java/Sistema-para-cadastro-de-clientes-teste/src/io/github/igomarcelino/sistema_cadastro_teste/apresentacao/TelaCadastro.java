package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.EstadosBrasileiros;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo;
import io.github.igomarcelino.sistema_cadastro_teste.logica.BancoDeDadosFake;
import io.github.igomarcelino.sistema_cadastro_teste.logica.Cadastro;
import io.github.igomarcelino.sistema_cadastro_teste.logica.LogicaBancoDeDados;
import io.github.igomarcelino.sistema_cadastro_teste.utilitarios.ConverterFotoParaArray;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;

import static io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo.M;

public class TelaCadastro extends JFrame {

    private JLabel labelCodigo;
    private JTextField textCodigo;
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
    private JButton btnLimparCampos;
    private JLabel labelImagem;
    private JButton btnAdicionarImagem;

    private Cadastro<Cliente> bancoDados;

    // construtor
    public TelaCadastro() {

        var conexao = Conexao.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        bancoDados = new LogicaBancoDeDados(clienteDAO);
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

    //Metodo para adicionar os label e campos na tela
    public void adicionarCampos(){

        labelCodigo = new JLabel("Codigo");
        labelCodigo.setBounds(480,20,60,20);
        getContentPane().add(labelCodigo);
        textCodigo = new JTextField();
        textCodigo.setBounds(530,20,40,20);
        getContentPane().add(textCodigo);

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

        labelImagem = new JLabel();
        labelImagem.setBounds(350,220,200,200);
        labelImagem.setIcon(adicionarImagemPadrao());
        getContentPane().add(labelImagem);



    }

    public void adicionarBotao(){

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20,420,80,20);
        getContentPane().add(btnSalvar);


        btnSalvar.addActionListener(salvarCliente());

        btnLimparCampos = new JButton("Limpar");
        btnLimparCampos.setBounds(110,420,90,20);
        getContentPane().add(btnLimparCampos);

        btnLimparCampos.addActionListener(botaoLimparCampos());

        btnFechar = new JButton("Fechar");
        btnFechar.setBounds(210,420,90,20);
        getContentPane().add(btnFechar);

        btnFechar.addActionListener(fecharJanela());

        btnAdicionarImagem = new JButton("Adicionar foto");
        btnAdicionarImagem.setBounds(370,440,150,20);
        getContentPane().add(btnAdicionarImagem);
        btnAdicionarImagem.addActionListener(adicionarImagem());



    }

    //ActionerListener para salvar cliente
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

                byte[] bytes = ConverterFotoParaArray.conversorFotoArray(labelImagem.getIcon());
                cliente.setFotoArray(bytes);

                try {
                    bancoDados.salvarCliente(cliente);
                    bancoDados.imprimirCliente(cliente);

                    limparCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }

        };
    }
    //ActionerLister para limpar campos
    public ActionListener botaoLimparCampos(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        };
    }
    // Metodo para limpar campos ao salvar
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
    // ActionListener para fechar a janela
    public ActionListener fecharJanela(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        };
    }

    // Metodo para adicionar o campo de imagem padrao

    public Icon adicionarImagemPadrao(){
        String caminho = "/io/github/igomarcelino/sistema_cadastro_teste/utilitarios/imagens/avatarPadrao.png";
        URL url = getClass().getResource(caminho);
        Image preIcon = new ImageIcon(url).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon iconPadrao = new ImageIcon(preIcon);

        return iconPadrao;
    }

    public ActionListener adicionarImagem(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser(); // instancia objeto JfileChooser
                int opcao = jFileChooser.showOpenDialog(null); // salva um int com o retorno da escolha do arqvuivo

                if(opcao == JFileChooser.APPROVE_OPTION){ // se o retorno do arquivo for igual o valor da constante Aprove_Option
                    File fotoSelecionada = jFileChooser.getSelectedFile();
                    String caminhoFoto = fotoSelecionada.getAbsolutePath();

                    Image novaFoto = new ImageIcon(caminhoFoto).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
                    ImageIcon novaFotoRenderizada = new ImageIcon(novaFoto);
                    labelImagem.setIcon(novaFotoRenderizada);
                }
            }
        };
    }
}




