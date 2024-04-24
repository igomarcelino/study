package exercices;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class QuadradoDeNumero {
    public static void main(String[] args) {
        //TODO Escreva um programa que declare uma variável do tipo double e calcule o quadrado
        //desse número.
        Scanner teclado = new Scanner(System.in);
        NumberFormat format = new DecimalFormat("#0,00");

        double numero ;

        System.out.println("Informe um numero: ");
        numero = teclado.nextDouble();
        numero = Math.pow(numero,2);// classe math que faz operacoes matematicas https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
        System.out.println("O quadrado desse numero e: "+numero);

    }
}
