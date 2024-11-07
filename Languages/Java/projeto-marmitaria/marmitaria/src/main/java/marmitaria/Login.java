package marmitaria;

import javax.swing.*;

public class Login extends JFrame {
    private JPanel jPanelMain;
    private JButton entrarButton;
    private JButton fecharButton;
    private JTextField usuarioTextField;
    private JPasswordField passwordTextField;
    private JLabel usuarioLabel;
    private JLabel senhaLabel;

    public void criarTela(){
        this.setContentPane(jPanelMain);
        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
