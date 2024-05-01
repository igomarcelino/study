package exercices;

public class NumerosPares2a20 {
    public static void main(String[] args) {
        /**
         *      TODO
         *          Escreva um programa Java que imprima os números pares de 2 a 20 usando um
         *          loop for.
         * */


        for ( int i = 0 ; i < 20 + 1 ; i++){
            if ( i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
