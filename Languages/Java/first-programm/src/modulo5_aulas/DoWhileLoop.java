package modulo5_aulas;

import java.util.Scanner;

public class DoWhileLoop {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int numero;

        do {
            System.out.println("[1] Novo\n[2] Abrir\n[3] Sair");
            numero = teclado.nextInt();
            switch (numero){
                case 1:
                    System.out.println("Selecionou Novo");
                    break;
                case 2 :
                    System.out.println("Selecionou Abrir");
                    break;
                case 3 :
                    System.out.println("Seleciou sair");
                    break;
                default:
                    System.out.println("Informe uma opcao valida");
            }
        }while (numero != 3);
        teclado.close();
        System.out.println("Sistema finalizado");
    }
}
