import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {


            //feed de Pessoas
        Pessoa p1 = new Pessoa("João Silva", "123.456.789-00", 'M', "30");
        Pessoa p2 = new Pessoa("Maria Oliveira", "987.654.321-00", 'F', "25");
        Pessoa p3 = new Pessoa("Carlos Souza", "111.222.333-44", 'M', "40");
        Pessoa p4 = new Pessoa("Ana Costa", "555.666.777-88", 'F', "22");
        Pessoa p5 = new Pessoa("Paulo Mendes", "999.888.777-66", 'M', "35");
        Pessoa p6 = new Pessoa("Juliana Lima", "444.333.222-11", 'F', "28");
        Pessoa p7 = new Pessoa("Lucas Almeida", "666.555.444-33", 'M', "32");
        Pessoa p8 = new Pessoa("Fernanda Ribeiro", "777.888.999-00", 'F', "27");
        Pessoa p9 = new Pessoa("Bruno Rocha", "222.333.444-55", 'M', "29");
        Pessoa p10 = new Pessoa("Patrícia Ferreira", "333.222.111-99", 'F', "31");

        // List de pessoas
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(p1);
        pessoaList.add(p2);
        pessoaList.add(p3);
        pessoaList.add(p4);
        pessoaList.add(p5);
        pessoaList.add(p6);
        pessoaList.add(p7);
        pessoaList.add(p8);
        pessoaList.add(p9);
        pessoaList.add(p10);

        System.out.println(pessoaList);

        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (int i = 0; i < pessoaList.size(); i++){
            modeloLista.addElement(pessoaList.get(i).getNome());
        }

        JList<String> jList = new JList<>(modeloLista);
        JScrollPane jScrollPane = new JScrollPane(jList);
        JButton btnMostrar = new JButton("Mostrar selecao");
        btnMostrar.setBounds(300,20,150,20);
        JFrame jFrame = new JFrame("Tela de teste");
        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(3);
        jFrame.add(btnMostrar);
        jFrame.add(jScrollPane);
        jFrame.setVisible(true);

    }
}
