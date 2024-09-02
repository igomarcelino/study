package Poli;

public class CalculadoraImposto {

    public static void impostoComputador(Computador computador){
        System.out.println("Imposto Computador");
        double valorImposto = computador.taxacao();
        System.out.println("Nome do computador: " + computador.getPreco());
        System.out.println("Valor do coputador: " + computador.getPreco());
        System.out.println("Valor do imposto: " + valorImposto);
    }

    public static void impostoTomate(Tomato tomato){
        System.out.println("Imposto Tomate");
        double valorImposto = tomato.taxacao();
        System.out.println("Nome do Tomate: " + tomato.getPreco());
        System.out.println("Valor do Tomate: " + tomato.getPreco());
        System.out.println("Valor do imposto: " + valorImposto);
    }




}
