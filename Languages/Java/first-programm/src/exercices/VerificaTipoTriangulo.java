package exercices;

import java.util.Scanner;

public class VerificaTipoTriangulo {
    public static void main(String[] args) {
        /**TODO
         *  Escreva um programa que leia as medidas dos lados de um triângulo e escreva se
         *  ele é Equilátero, Isósceles ou Escaleno. Sendo que:
            * a. Triângulo Equilátero: possui os 3 lados iguais.
             * b. Triângulo Isósceles: possui 2 ladosiguais.
             * c. Triângulo Escaleno: possui 3 ladosdiferentes.
         * */

        Scanner teclado = new Scanner(System.in);

        double lado1, lado2, lado3;

        System.out.println("Informe o lado 1: ");
        lado1 = teclado.nextDouble();
        System.out.println("Informe o lado 2: ");
        lado2 = teclado.nextDouble();
        System.out.println("Informe o lado 3: ");
        lado3 = teclado.nextDouble();

        if ( lado1 == lado2 && lado1 == lado3) {
            System.out.println("Triangulo Equilatero");
        }else if ( lado1 == lado2 || lado1 == lado3 || lado3 == lado2 ){
            System.out.println("Triangulo Isosceles");
        }else {
            System.out.println("Triangulo Escaleno");
        }

    }
}
