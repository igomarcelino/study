package exercices;

import java.util.Scanner;

public class MediaDosInteirosArray {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que solicite ao usuário que insira 5 números inteiros e
         *      armazene-os em um array. Em seguida, calcule e imprima a média dos números.
         * */

        Scanner teclado = new Scanner(System.in);

        int[] numeros = new int[5];
        int sum = 0;
        for (int i : numeros){
            System.out.println("informe um numero inteiro: ");
            i = teclado.nextInt();
            sum += i;
        }
        double average = sum/numeros.length;
        teclado.close();
        System.out.println("A media dos numeros e :" + average);
    }
}
