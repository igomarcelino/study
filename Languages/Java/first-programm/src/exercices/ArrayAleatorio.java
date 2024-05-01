package exercices;

import java.util.Random;

public class ArrayAleatorio {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que preencha um array de inteiros com valores
         *      aleatórios entre 1 e 100 e, em seguida, imprima o índice do primeiro elemento par
         *      encontrado no array.
         * */

        int [] numeros = new int[10];
        int firstPairNumber = -1 ;
        int pairNumber = 0;
        Random numeroRandom = new Random(); // utilizando a classe random para preencher o numero


        for (int i = 0; i < numeros.length;i++){ // atribui os valores ao array
            numeros[i] = numeroRandom.nextInt(100);
        }

        for ( int i = 0;i < numeros.length; i++){
            if( numeros[i] % 2 == 0){ // verifica se o numero e par
                firstPairNumber = i; // armazena o indice do numero par
                pairNumber = numeros[i];
                break;
            }
        }

        if (firstPairNumber != -1 ){ // verifica se foi encontrado algum numero par
            System.out.println("O primeiro numero par e: "+ pairNumber +" foi encontrado no indice: "+ firstPairNumber);
        }else {
            System.out.println("Nao foi encontrado nenhum numero par.");
        }


    }
}
