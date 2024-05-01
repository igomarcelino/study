package exercices;

public class NumerosPrimosFor {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que imprima os números primos entre 1 e 50 usando um
         *      loop for.
         * */

        int contador = 0;
        int numeroPrimo = 0;

        for (int i = 1 ; i < 50 +1 ; i ++){
            contador = 0;
            for ( int j = 1; j <= i; j++){
                if ( i % j == 0 ) {
                    contador ++;
                }
                }
            if(contador == 2 ){
                numeroPrimo = i;
                System.out.println(numeroPrimo);
            }
        }
    }
}
