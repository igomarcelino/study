package modulo5_aulas;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o valor para contar: ");
        int valor = teclado.nextInt();
        teclado.close();

        for (int contatdor = 1; contatdor <= valor; contatdor++){
            System.out.println(contatdor);
        }

        System.out.println("Fim da contagem !");
    }
}
