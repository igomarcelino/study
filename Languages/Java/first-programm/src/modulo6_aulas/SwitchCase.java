package modulo6_aulas;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Selecione uma opcao");
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");

            opcao = teclado.nextInt();

                switch (opcao){ // abertura do switch
                    case 1:
                        System.out.println("Solicitou a opcao 1"); // caso o inteiro 1 seja digitado , seguira por esse caminho do switch
                        break;
                    case 2:
                        System.out.println("Solicitou a opcao 2");
                        break;
                    case 3:
                        System.out.println("Solicitou a opcao 3");
                        break;
                    default:
                        System.out.println("Selecione uma opcao!");
                }

        }while (opcao != 3);
    }
}
