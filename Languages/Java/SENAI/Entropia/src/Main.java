import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] dengueCasos = {"positivo", "negativo", "positivo", "negativo","positivo", "positivo", "negativo"};
        double entropia = calcularEntropia(dengueCasos);
        System.out.println("A Entropia dos dados de dengue: " + entropia);
    }

    // Definir o calculo da entropia
    public static double calcularEntropia(String[] rotulos){
        Map<String, Integer> contagemRotulos = new HashMap<>();
        // Realizar a contagem de cada rotulo

        for(String rotulo : rotulos){
            contagemRotulos.put(rotulo, contagemRotulos.getOrDefault(rotulo,0)+1);
        }
        // calcular a entropia
        double entropia = 0.0;

        for (Map.Entry<String, Integer> entry : contagemRotulos.entrySet()){
           int totalRotulos = rotulos.length;
            double probabilidade = ( double) entry.getValue() / totalRotulos;
            entropia -= probabilidade * log2(probabilidade);
        }
        return entropia;
    }
    //definir logaritmo na base 2

    public static double log2(double valor){
        return Math.log(valor)/Math.log(2);
    }
}
