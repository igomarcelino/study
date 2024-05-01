package exercices;

import java.util.Scanner;

public class CalculadoraDeImpostos {
    public static void main(String[] args) {
        /**
         *  TODO
         *     Crie um programa Java que simule uma calculadora de impostos. Solicite ao usuário
         *     que informe o salário bruto e utilize uma expressão booleana para determinar se o
         *     salário está sujeito ao imposto de renda (acima de R$ 2000,00). Se estiver, calcule e
         *     imprima o valor do imposto (15% sobre o excedente)
         * */

        Scanner teclado = new Scanner(System.in);
        double imposto = 0.0;
        System.out.println("Informe o valor do salario");
        double salario = teclado.nextDouble();
        if( salario > 2000.0){
            System.out.println("O Trabalhador devera pagar o imposto de 15%:");
            imposto = ( salario - 2000) * 0.15;
            System.out.print(", valor total do imposto devido:R$ "+ Math.round(imposto));
        }else
            System.out.println("Trabalhador isento de imposto");
    }
}
