package exercices;

import java.util.Scanner;

public class PerimetroRetangulo {
    public static void main(String[] args) {
        //TODO Escreva um programa que calcule o perímetro e a área de um retângulo.

        Scanner teclado = new Scanner(System.in);

        double base, altura, perimetro;

        System.out.println("Informe a base do retangulo: ");
        base = teclado.nextDouble();
        System.out.println("Informe a Altura do retangulo: ");
        altura = teclado.nextDouble();

        perimetro = 2 * (base + altura); // Formula de perimetro do retangulo
        System.out.println("O perimetro do retangulo e: " + perimetro);
    }
}
