package exercices;

import javax.swing.text.StyledEditorKit;
import java.text.BreakIterator;
import java.util.Scanner;

public class DiaDaSemanaSwitch {
    public static void main(String[] args) {
        /**
         *  TODO
         *      Escreva um programa Java que utilize a estrutura de controle switch-case para
         *      determinar o dia da semana com base em um número fornecido pelo usuário (1 para
         *      Domingo, 2 para Segunda-feira, etc.), exibindo uma mensagem correspondente.
         * */

        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe o dia da semana no formato de 1 ate 7 para saber qual dia e ");
        int dayOfWeek = teclado.nextInt();
        switch (dayOfWeek){
            case 1:
                System.out.print(" Domingo ");
                break;
            case 2:
                System.out.print(" Segunda ");
                break;
            case 3:
                System.out.print(" terca-feira");
                break;
            case 4:
                System.out.print(" Quarta-feira");
                break;
            case 5:
                System.out.print(" Quinta-feira");
                break;
            case 6:
                System.out.print(" Sexta-feira");
                break;
            case 7:
                System.out.print(" Sabado");
                break;
            default:
                System.out.print(" Por favor informe um numero");
        }
    }
}
