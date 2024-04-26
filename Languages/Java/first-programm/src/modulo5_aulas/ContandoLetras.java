package modulo5_aulas;

import java.util.Scanner;

public class ContandoLetras {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        String frase = teclado.nextLine();
        teclado.close();

        int quantidadeLetras = 0;

        for (int i =0;i < frase.length();i++){
            char letra = frase.charAt(i);
            boolean isLetra = Character.isLetter(letra);
            if(isLetra)
                quantidadeLetras++;
        }

        System.out.println("Quantidade de letras da frase: " + quantidadeLetras);
    }
}
