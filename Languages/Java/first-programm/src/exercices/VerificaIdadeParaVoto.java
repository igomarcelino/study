package exercices;

import java.time.Instant;
import java.time.LocalDate;

import java.util.Scanner;

public class VerificaIdadeParaVoto {
    public static void main(String[] args) {
        /**TODO Escreva um programa para ler o ano de nascimento de uma pessoa e escrever uma
            mensagem que diga se ela poderá ou não votar este ano.
        * */

        Scanner teclado = new Scanner(System.in);

        int ano  ;

        int year = LocalDate.now().getYear(); // localDate acessa o sistema para tratar informacoes referente a data
        //https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html

        System.out.println("Informe o ano de nascimento: ");
        ano = teclado.nextInt();
        if ( (year - ano) >  16 ){
            System.out.println("Voce pode votar esse ano");
        }else {
            System.out.println("Voce ainda nao pode votar");
        }


    }
}
