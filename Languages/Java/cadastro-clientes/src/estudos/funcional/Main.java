package estudos.funcional;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Calculadora calculadora;
        var num1 = 0;
        var num2 = 0;
        System.out.println("---- CALCULADORA ----");
        System.out.println("Escola a opcao");
        System.out.println("[ 1 ] Somar");
        System.out.println("[ 2 ] Subtrair");
        System.out.println("[ 3 ] Multiplicar");
        System.out.println("[ 4 ] Dividir");
        var opcao = teclado.nextInt();
        switch (opcao){
            case 1 :
                System.out.print("Digite um numero: ");
                num1 = teclado.nextInt();
                System.out.print("Digite outro numero: ");
                num2 = teclado.nextInt();
                calculadora = (x, y) -> x + y ;
                System.out.println("Resultado: "+calculadora.calcular(num1,num2));
                break;
            case 2:
                System.out.print("Digite um numero: ");
                num1 = teclado.nextInt();
                System.out.print("Digite outro numero: ");
                num2 = teclado.nextInt();
                calculadora = (x, y) -> x - y ;
                System.out.println("Resultado: "+calculadora.calcular(num1,num2));
                break;
            case 3 :
                System.out.print("Digite um numero: ");
                num1 = teclado.nextInt();
                System.out.print("Digite outro numero: ");
                num2 = teclado.nextInt();
                calculadora = (x, y) -> x * y ;
                System.out.println("Resultado: "+calculadora.calcular(num1,num2));
                break;
            case 4:
                System.out.print("Digite um numero: ");
                num1 = teclado.nextInt();
                System.out.print("Digite outro numero: ");
                num2 = teclado.nextInt();
                calculadora = (x, y) -> x / y ;
                System.out.println("Resultado: "+calculadora.calcular(num1,num2));
                break;
        }
    }
}
