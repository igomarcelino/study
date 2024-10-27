package one.digitalinnovation;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinanySearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int i = 0;
        Random random = new Random();
        while (i  < 10){
            array[i] = random.nextInt(100);
            i++;
        }

        System.out.println("Numeros sem ordenacao");
        for (int j =0;j < array.length -1 ; j++){
            System.out.println("Numero: " + array[j]);
        }
        System.out.println("Numeros com ordenacao");
        Arrays.sort(array);
        for (int j =0;j < array.length -1 ; j++){
            System.out.println("Numero: " + array[j]);
        }

        System.out.println("Informe o numero a ser procurado");
        int num = scanner.nextInt();

        localizarNumero(num, array);

    }

    public static  void localizarNumero(int numero, int[] array) {
        int inicio = 0;
        int fim = array.length - 1;
        int passos = 0;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (array[meio] == numero) {
                System.out.println("Numero encontrado");
                break;
            }
            /**
             * caso o numero contido no meio do array for menor do que o numero a ser localizado
             * entendemos que o numero esta na metade superior do array, sendo assim fazemos os
             * ajustes necessarios sendo eles, o inicio do loop se dara da metade para frente,
             * sendo assim o novo inicio sera o meio +1 porque o indice do meio ja foi testado, sendo
             * assim o proximo a ser testado e o indice do meio mais 1
             * */

            if (array[meio] < numero){
                inicio = meio + 1;
            }
            /**
             * Caso o numero contido no meio do array for maior do que o numero a ser localizado,
             * entao ajustamos a varivel fim para meio - 1, pois sabemos que o indice meio ja foi testado
             * A nova busca se da na metade do novo tamanho do array
             * */
            if (array[meio] > numero){
                fim = meio - 1;
            }
            // Essa variavel conta quantos indices foram testados
            passos++;
        }

        System.out.println("Tamanho do array: " + array.length);
        System.out.println("Passos percorridos: " + passos);
    }
}
