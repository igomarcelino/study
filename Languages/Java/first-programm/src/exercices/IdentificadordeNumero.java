package exercices;

import java.util.Scanner;

import static java.lang.System.*;

public class IdentificadordeNumero {
    public static void main(String[] args) {
        //TODO Escreva um programa que determine se um número é positivo, negativo ou zero

        Scanner teclado = new Scanner(in);

        int numero;

        out.println("Informe um numero: ");
        numero = teclado.nextInt();

        if ( numero > 0 ){ // testa se a condicao e verdadeira
            out.println("O numero "+ numero + " e positivo.");
        }
        if ( numero < 0 ){
            out.println("O numero " + numero + " e negativo");
        }
        else if ( numero == 0)
            out.println("O numero digitado foi 0");

    }
}
