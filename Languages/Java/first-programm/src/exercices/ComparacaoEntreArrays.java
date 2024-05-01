package exercices;

import java.util.Random;

public class ComparacaoEntreArrays {
    public static void main(String[] args) {
        /***
         *  TODO
         *      Escreva um programa Java que declare dois arrays de inteiros com o mesmo
         *      tamanho e calcule a soma dos elementos correspondentes em ambos os arrays,
         *      armazenando o resultado em um terceiro array. Em seguida, imprima o array
         *      resultante.
         */

        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int[] array3 = new int[5];


        Random randomNumber = new Random();

        System.out.println("Array 1");
        for(int i = 0; array1.length > i; i++){
            array1[i] = randomNumber.nextInt(10);
            System.out.print(array1[i] + " ");
        }
        System.out.println("  ");
        System.out.println("Array 2");
        for(int i = 0; array2.length > i; i++){
            array2[i] = randomNumber.nextInt(10);
            System.out.print(array2[i]+ " ");
        }

        System.out.println("\nSoma dos elementos correspondentes");
        int index = 0;
        for ( int i : array3){
            array3[index] = array1[index] + array2[index];
            System.out.print(array3[index]+ " ");
            index++;

        }


    }
}
