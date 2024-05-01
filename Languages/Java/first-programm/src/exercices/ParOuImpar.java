package exercices;

import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa que determine se um número é par ou ímpar
         * */

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe um numero: ");
        int numero = teclado.nextInt();
        String parOuImpar = numero % 2 ==0 ? "O numero e par" : "O numero e impar";
        System.out.println(parOuImpar);
    }
}
