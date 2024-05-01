package exercices;

public class MultiplosDe3E5 {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que imprima os números de 1 a 100, substituindo os
         *      múltiplos de 3 por "Fizz" e os múltiplos de 5 por "Buzz". Para os números que são
         *      múltiplos de ambos, imprima "FizzBuzz". Pode utilizar qualquer laço de repetição
         *      (while ou for).
         * */

        int aux = 0;
        for (int i = 1; i < 100 + 1; i++) {

            if ( i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            }else
                System.out.println(i);
            // Quando utilizamos um else if ele entra na linha e finaliza os testes logicos daquele bloco
        }
    }
}

