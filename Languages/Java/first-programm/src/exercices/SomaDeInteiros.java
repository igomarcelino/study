package exercices;

import java.util.Scanner;

public class SomaDeInteiros {

    public static void main(String[] args) {
        //TODO Escreva um programa para declarar duas variáveis do tipo inteiro e calcular sua
        //soma.
        Scanner teclado = new Scanner(System.in); // objeto teclado instanciado da classe Scanner

        int number1 ;
        int number2 ;
        int sum ;

        System.out.println("Informe um numero: "); // saida , printa mensagem na tela
        number1 = teclado.nextInt(); // entrada , le um dado digitado , nesse caso um inteiro
        System.out.println("Informe um segundo numero: ");
        number2 = teclado.nextInt();
        sum = number1 + number2; // sum recebe a soma de numero1 + numero 2
        System.out.println("Resultado: "+sum); // saida , printa o conteudo de sum na tela


    }
}
