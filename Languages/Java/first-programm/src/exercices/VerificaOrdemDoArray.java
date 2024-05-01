package exercices;

import java.util.OptionalInt;
import java.util.Random;
import java.util.Arrays;

public class VerificaOrdemDoArray {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Crie um programa Java que declare um array de inteiros e verifique se ele está
         *      ordenado de forma crescente.
         * */

        Random randomNumber = new Random();

        int[] array = new int[3];
        boolean isOrdered = true;

        for( int i = 0; i <  array.length; i ++ ) {
            array[i] = randomNumber.nextInt(20);
            System.out.print(array[i]+ " ");
        }


        int temp = 0 ;
        for (int i = 0; i < array.length ; i++){ // valida se esta em ordem crescente , se entrar no if e que nao esta em ordem crescente
            for (int j = i+1 ; j< array.length; j++){
                if ( array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = array[i];
                    isOrdered = false;
                }
            }
        }

        System.out.println("O array esta ordenado? : " + isOrdered);
    }
}
