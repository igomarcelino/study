package exercices;

public class Calcular1a100While {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que calcule a soma dos números de 1 a 100 usando um
         *      loop while.
         * */

        int numero = 1 ;
        int somaDosNumeros = 0;
        while (numero <= 100){
            somaDosNumeros += numero;
            numero++;

        }
        System.out.println(somaDosNumeros);
    }
}
