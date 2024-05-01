package exercices;

import java.awt.desktop.SystemEventListener;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MaiorOuMenorTernario {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que permita ao usuário digitar a idade de uma pessoa e
         *      utilize o operador ternário para determinar se a pessoa é maior ou menor de idade,
         *      exibindo uma mensagem correspondente
         * */

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a sua idade: ");
        int idade = teclado.nextInt();
        teclado.close();
        String maiorOuMenor = idade > 18 ? "Maior de idade" : "Menor de idade" ;
        System.out.println(maiorOuMenor);
    }
}
