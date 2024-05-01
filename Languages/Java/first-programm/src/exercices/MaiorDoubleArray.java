package exercices;

import java.util.Arrays;

public class MaiorDoubleArray {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Crie um programa Java que declare um array contendo 5 números double (ex: 10.5,
         *      20.7, 15.3, 40.2, 8.9) e encontre o maior elemento no array (resposta: 40.2).
         * */

        double[] numeros = {10.5, 20.7, 15.3, 40.2, 8.9};

        double max = Arrays.stream(numeros).max().getAsDouble(); //Stream , cria uma lista sequencial

        System.out.println("O maior valor no array e: " + max);
    }
}
