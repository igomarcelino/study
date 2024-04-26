package modulo5_aulas;

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int numero ;
        int contador = 1;
        int numerosPares = 0;

        System.out.println("informe um numero maior que 0 para mostrar todos os pares ate ele: ");
        numero = teclado.nextInt();
        teclado.close();
        while ( contador <= numero) {
            if(contador % 2 == 0){
                System.out.println(contador);
                numerosPares++;
            }
            contador++;
        }
        System.out.println("Contagem finalizada. Foram encontrados "+ numerosPares + " numeros par no intervalo de numero informado");
    }
}
