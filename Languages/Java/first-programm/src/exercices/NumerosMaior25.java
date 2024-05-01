package exercices;

import java.util.Random;

public class NumerosMaior25 {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Crie um programa Java que preencha um array de inteiros com valores aleatórios
         *      entre 1 e 50 e, em seguida, imprima a média dos valores maiores que 25
         * */

        Random randomNumber = new Random();
        int[] numbers = new int[10];
        int count = 0;
        int numberOver25 = 0;


        for (int i : numbers){
            i = randomNumber.nextInt(50);
            System.out.println(i);
            if ( i > 25 ) {
                numberOver25 += i;
                count++;
            }
        }



    }
}
