package exercices;

import java.util.Scanner;

public class MediaNumeros {
    public static void main(String[] args) {
        //TO-DO Escreva um programa Java que calcule a média de três números inteiros

        Scanner teclado = new Scanner(System.in);

        int numero1, numero2, numero3;

        double media;

        System.out.println("Informe o numero 1: ");
        numero1 = teclado.nextInt();
        System.out.println("Informe o numero 2: ");
        numero2 = teclado.nextInt();
        System.out.println("Informe o numero 3: ");
        numero3 = teclado.nextInt();
        media = (numero1 + numero2 + numero3) / 3 ; // calcula a media entre o s numeros digitados
        System.out.println("A media entre os numeros digitados e: "+ media);
    }
}
