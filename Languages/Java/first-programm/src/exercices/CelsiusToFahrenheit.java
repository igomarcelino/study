package exercices;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        //TODO Escreva um programa Java que converta graus Celsius para Fahrenheit.

        Scanner teclado = new Scanner(System.in);
        double graus, grausFahrenheit ;

        System.out.println("Informe a temperatura em Celsius: ");
        graus = teclado.nextDouble();
        grausFahrenheit = ( graus * 9/5) + 32; // Formula celsius para fahrenheit
        System.out.println("A temperatura em Fahrenheit e: "+ grausFahrenheit);

    }
}
