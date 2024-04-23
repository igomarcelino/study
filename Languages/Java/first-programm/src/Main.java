import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame janela = new JFrame("Primeiro programa"); // instancia do objeto Jframe
        JLabel labelNome = new JLabel("Nome: ");
        JTextField campoTextoNome = new JTextField();
        JButton enviarNomeBotao = new JButton("Enviar");


        labelNome.setBounds(20,20,50,30);
        campoTextoNome.setBounds(20,60,200,20);
        enviarNomeBotao.setBounds(20,100,80,30);

        janela.setSize(500,500); // tamanho da janela
        janela.setLayout(null); // Define o layout como nulo
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // finaliza a execucao da janela
        janela.getContentPane().add(labelNome); // Adiciona um componente na janela
        janela.getContentPane().add(campoTextoNome);
        janela.getContentPane().add(enviarNomeBotao);

        enviarNomeBotao.addActionListener(e -> {
            String enviarNome = campoTextoNome.getText(); // Cria uma string para armazenar o nome do campoTextNome
            JOptionPane.showMessageDialog(janela,enviarNome,"Ola !!",JOptionPane.INFORMATION_MESSAGE); // cria uma caixa de dialogo contendo o conteudo da String enviar Nome
            //https://docs.oracle.com/javase/tutorial/uiswing/components/dialog.html
        });

        janela.setVisible(true); // Visibilidade do objeto , mostra a janela do tamanho definido na tela
    }
}