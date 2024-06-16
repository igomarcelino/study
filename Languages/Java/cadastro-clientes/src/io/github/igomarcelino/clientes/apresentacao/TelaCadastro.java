package io.github.igomarcelino.clientes.apresentacao;

import io.github.igomarcelino.clientes.dados.ClienteDAO;
import io.github.igomarcelino.clientes.dados.FabricaConexoes;
import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;
import io.github.igomarcelino.clientes.logicanegocio.Cadastro;
import io.github.igomarcelino.clientes.logicanegocio.LogicaCadastroBancoDados;
import io.github.igomarcelino.clientes.utilitarios.ConverterIcoParaByteArray;
import io.github.igomarcelino.clientes.logicanegocio.LogicaCadastroMemoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class TelaCadastro extends JFrame {

        // atributes
        private JLabel labelNome;
        private TextField fieldNome;
        private JLabel labelCpf;
        private TextField fieldCpf;
        private JLabel labelSexo;
        private JLabel labelImagem;
        private JComboBox boxSexo;
        private JButton btnSalvar;
        private JButton btnAlterarFoto;

        private Cadastro<Cliente> clienteCadastro;


    public TelaCadastro()  {

        ClienteDAO clienteDAO =  new ClienteDAO(FabricaConexoes.criarConexao());
        this.clienteCadastro = new LogicaCadastroBancoDados(clienteDAO);
        construirTela();
    }

    public void construirTela(){
        setSize(600,400);
        setTitle("Cadastro de clientes");
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        adicionarCampos();
        adicionarBotao();
        adicionarImagem();
    }

    // add labels and fields on screen
    private void adicionarCampos(){

        // label nome
        labelNome = new JLabel("Nome: ");
        labelNome.setBounds(20,20,60,20);
        getContentPane().add(labelNome);

        // field nome
        fieldNome = new TextField();
        fieldNome.setBounds(80,20,200,20);
        getContentPane().add(fieldNome);


        // label cpf
        labelCpf = new JLabel("CPF: ");
        labelCpf.setBounds(20,60,60,20);
        getContentPane().add(labelCpf);

        //field cpf
        fieldCpf = new TextField();
        fieldCpf.setBounds(80,60,200,20);
        getContentPane().add(fieldCpf);

        // label sexo
        labelSexo = new JLabel("Sexo: ");
        labelSexo.setBounds(20,100,80,20);
        getContentPane().add(labelSexo);

        // combobox sexo

        TipoSexo[] tipoSexo = {null, TipoSexo.M, TipoSexo.F, TipoSexo.O};
        boxSexo = new JComboBox(tipoSexo);
        boxSexo.setBounds(80,100,40,20);
        getContentPane().add(boxSexo);

        //
    }

    //add buttons on screen
    private void adicionarBotao(){
        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20,160,100,20);

        ActionListener acaoBotaoSalvar = this.botaoSalvar();// instancia do listener
        btnSalvar.addActionListener(acaoBotaoSalvar); // adicionando a acao do listener



        getContentPane().add(btnSalvar);

    }

    public ActionListener botaoSalvar(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.setNome(fieldNome.getText());
                cliente.setCpf(fieldCpf.getText());
                cliente.setSexo((TipoSexo) boxSexo.getSelectedItem());
                byte[] bytes = ConverterIcoParaByteArray.conversor(labelImagem.getIcon());
                cliente.setFoto(bytes);
                try {
                    clienteCadastro.salvar(cliente);
                    zerarCampos();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }


            }
        };
    }

    public void adicionarImagem(){

        ImageIcon ico = imagemPadrao();

        labelImagem = new JLabel();
        labelImagem.setIcon(ico);
        labelImagem.setBounds(350,20,200,200);
        getContentPane().add(labelImagem);

        btnAlterarFoto = new JButton("Alterar foto");
        btnAlterarFoto.setBounds(360,210,130,20);
        btnAlterarFoto.addActionListener(alterarFotoActionListener());
        getContentPane().add(btnAlterarFoto);

    }

    private ImageIcon imagemPadrao() {
        String caminhoImagem = "/io/github/igomarcelino/clientes/imagens/arquivos-de-imagem.png";

        URL url = getClass().getResource(caminhoImagem);

        Image imageIcon = new ImageIcon(url).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon ico = new ImageIcon(imageIcon);
        return ico;
    }

    private void zerarCampos(){
        fieldNome.setText("");
        fieldCpf.setText("");
        boxSexo.setSelectedItem(null);
        labelImagem.setIcon(this.imagemPadrao());
    }

    private ActionListener alterarFotoActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int opcao = jFileChooser.showOpenDialog(null);

                if (opcao == JFileChooser.APPROVE_OPTION){
                    File arquivoCapturado = jFileChooser.getSelectedFile();
                    String arquivoSelecionado = arquivoCapturado.getAbsolutePath();

                    Image newFoto = new ImageIcon(arquivoSelecionado).getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
                    labelImagem.setIcon(new ImageIcon(newFoto));
                }
            }
        };
    }
}
