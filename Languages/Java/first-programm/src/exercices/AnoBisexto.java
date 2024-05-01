package exercices;

import java.util.Scanner;

public class AnoBisexto {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Faça um programa que verifica se um ano fornecido pelo usuário é bissexto. Se o
         *      ano não termina em 00, ele é bissexto caso seja divisível por 4. Exemplos: 1988,
         *      1992, 1996, 2004, e assim por diante. Nota: Um número é divisível por 4 se a sua
         *      dezena (1988 = 88) é divisível por 4
         * */

        Scanner teclado = new Scanner(System.in);

        System.out.println("informe um ano para verificar se ele e bixesto: ");
        int ano = teclado.nextInt() % 100 ;
        teclado.close();

        String anoBisexto = ano % 4 == 0 && ano != 00? "O ano e bisexto" : "O ano nao e bisexto";
        System.out.println(anoBisexto);
    }
}
