package exercices;

import java.util.Scanner;

public class ParOuImparTernario {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que utilize o operador ternário para determinar se um
         *      número fornecido pelo usuário é par ou ímpar, exibindo uma mensagem
         *      correspondente.
         * */

        Scanner teclado = new Scanner(System.in);

        System.out.print("Informe um numero para verificar se e par ou impar: ");
        int numero = teclado.nextInt();
        String parOuImpar = (numero % 2 == 0) ? "O numero digitado e par" : "O numero digitado e impar";
        System.out.println(parOuImpar);
    }
}
