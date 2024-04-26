package modulo4_aulas;

import java.util.Scanner;

public class CalcularMediaTrimestre {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        double notaTrimestre1 ;
        double notaTrimestre2 ;
        double notaTrimestre3 ;
        double mediaFinal ;



        System.out.println("Informe a nota do trimestre 1 : ");
        notaTrimestre1 = teclado.nextDouble();
        System.out.println("Informe a nota do trimestre 2 : ");
        notaTrimestre2 = teclado.nextDouble();
        System.out.println("Informe a nota do trimestre 3 : ");
        notaTrimestre3 = teclado.nextDouble();
        teclado.close();

        mediaFinal = ( notaTrimestre1 + notaTrimestre2 + notaTrimestre3) / 3 ;
        if (mediaFinal >= 6)
            System.out.println("Aprovado");
        else
            System.out.println("Reprovado");



    }
}
