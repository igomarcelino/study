package exercices;

import java.util.Scanner;

public class ArrayInformadoPeloUsuario {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Crie um programa Java que solicite ao usuário que insira o tamanho de um array de
         *      inteiros e, em seguida, preencha o array com números fornecidos pelo usuário. Por
         *      fim, imprima o array.
         * */

        Scanner teclado = new Scanner(System.in);


        System.out.println("Informe o tamanho do array: ");
        int indiceArray = teclado.nextInt();
        int[] arrayNumeros = new int[indiceArray];
        int index = 0;
        for ( int i : arrayNumeros){
            System.out.println("informe um numero: ");
            arrayNumeros[index] = teclado.nextInt(); // o array no index recebe o dado de entrada do teclado
            index++; // indice e interado
        }

        System.out.print("Os numeros digitados foram: ");
        for ( int i : arrayNumeros){

            System.out.print(i+ " ");
        }


    }
}
