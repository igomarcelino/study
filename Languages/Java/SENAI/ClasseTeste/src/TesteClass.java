import Poli.CalculadoraImposto;
import Poli.Computador;
import Poli.Produto;
import Poli.Tomato;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class TesteClass {
    public static void main(String[] args) {

        boolean verifica = pertenceFibonacci(4);
        System.out.println(verifica);
    }

    /*public static boolean validatePin(String pin) {
        // Your code here...

        return pin.matches("\\d{4}|\\d{6}");
    }

    public static double calcularVelocidadeMedia(String[] velocidades) {
        int total = 0;

        // TODO: Some todas as velocidades registradas e calcule a média
        return Arrays.stream(velocidades).map(valor -> Double.valueOf(valor)).reduce(0.0,(a,b) -> a+b) / velocidades.length;

    }
    public static String verificarQuedaConexao(String[] velocidades) {
        return Arrays.stream(velocidades).anyMatch(conexao -> conexao.equalsIgnoreCase("0")) ? "Queda de Conexao": "Sem Quedas";
    }*/

    public static boolean pertenceFibonacci(int numero) {
        int a = 0;
        int b = 1;
        int c = a + b;

        if (numero == a || numero == b) {
            return true;
        }
        while (c <= numero) {
            if (c == numero) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }

}
