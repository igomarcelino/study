package exercices;

import java.util.Scanner;

public class PesoIdeal {
    public static void main(String[] args) {
        /**
         * TODO
         *  endo como entrada a altura e o sexo (codificado da seguinte forma:
         *  digitando 1:feminino e digitando 2:masculino) de uma pessoa, construa um
         *  programa que
         *  calcule e imprima seu peso ideal, utilizando as seguintes
         *  Fórmulas:
         *  - para homens: (72.7 * Altura) – 58
         *  - para mulheres: (62.1 * Altura) – 44.7
         * */

        Scanner teclado = new Scanner(System.in);

        double altura ;
        double pesoIdeal = 0.0 ;
        int escolhaSexo ;

        System.out.println("Informe a sua altura: ");
        altura = teclado.nextDouble();
        System.out.println("Informe seu sexo: \n[ 1 ] Masculino \n[ 2 ] mulher ");
        escolhaSexo = teclado.nextInt();
        switch (escolhaSexo){ // Seleciona uma opcao baseada em uma selecao inteiro
            case 1 : // caso o numero informado na escolha seja 1 entrara no caso 1
                pesoIdeal = (72.7 * altura) - 58;
                break; // finaliza o switch
            case 2 :
                pesoIdeal = ( 62.1 * altura) - 44.7;
                break;
            default:
                System.out.println("Informe uma altura!!");
        }

        teclado.close();

        System.out.format("O seu peso ideal e: %.2f ",pesoIdeal);
    }
}
