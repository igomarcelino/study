import java.util.Scanner;

public class EncontreALetra {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe uma palavra: ");
        String palavra = teclado.nextLine().toLowerCase(); // deixa todas letras minusculas
        System.out.print("\nAgora informe uma letra para verificar se a palavra "+palavra+" contem e quantas vezes aparece: ");
        String letra =teclado.nextLine().toLowerCase();// deixa todas letras minusculas
        int encontradaXVezes = acharEContarLetra(palavra,letra);
        if (encontradaXVezes!=0){
            System.out.println("A letra "+ letra+" foi encontrada na palavra( "+palavra+" ) "+encontradaXVezes+" vez(es)");
        }else {
            System.out.println("A letra "+ letra+" nao foi encontrada na palavra( "+palavra+" )");
        }
    }

    public static int acharEContarLetra(String palavra,String letra){
        int contagem = 0;
        for (int i = 0; i < palavra.length();i++){
            if (palavra.charAt(i) == letra.charAt(0)){
                contagem++;
            }
        }
        return contagem;
    }
}
