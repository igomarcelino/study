package exercices;

import java.util.Scanner;

public class SomaDeDigitos {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que calcule a soma dos dígitos de um número inteiro.
         * */

        Scanner teclado = new Scanner(System.in);

        int soma = 0;

        System.out.println("informe um numero inteiro: ");
        int numero = teclado.nextInt();
        while ( numero != 0){
            soma += numero % 10;
            numero = numero / 10;

        }
        System.out.println(" A soma dos inteiros e : " +  soma);
    }
}
// Para esse exercicio usamos o resto da divisao para separar o ultimo
// numero , e atribuimos o numero da divisao inteira como novo numero
// sendo assim o while funcionara ate que o numero seja diferente de 0
