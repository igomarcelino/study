package exercices;

import java.util.Scanner;

public class CalcularPrecoMacas {
    public static void main(String[] args) {
        /**
         * TODO Dado que existe um mercado onde as maçãs custam R$ 0,30 cada se forem
         *  compradas menos do que uma dúzia, e R$ 0,25 se forem compradas pelo menos
         *  doze. Escreva um programa que leia o número de maçãs compradas, calcule e
         *  escreva o valor total da compra.
         * */

        Scanner teclado = new Scanner(System.in);

        double precoNormal = 0.30;
        double precoDesconto = 0.25;
        double precoTotal;

        int quantidadeMacas ;
        System.out.println("Informe a quantidade de macas: ");
        quantidadeMacas = teclado.nextInt();
        if (quantidadeMacas > 12 ){
            precoTotal = quantidadeMacas * precoDesconto;
        }else {
            precoTotal = quantidadeMacas * precoNormal;
        }
        System.out.println("Valor total da compra: " + precoTotal);
    }
}
