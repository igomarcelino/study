package io.github.igomarcelino.sistema_cadastro_teste.apresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JMenuBar menuBar ;
    private JMenu menuClientes;

    private JMenuItem novoCliente;

    public TelaPrincipal() throws HeadlessException {
        janela();
    }

    public void janela(){
        this.setSize(new Dimension(500,500));
        this.setDefaultCloseOperation(3);

        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menuClientes = new JMenu("Clientes");
        menuBar.add(menuClientes);

        novoCliente = new JMenuItem("Cadastrar Clientes");
        novoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.setVisible(true);
            }
        });
        menuClientes.add(novoCliente);



    }
}
