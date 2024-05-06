package io.github.igomarcelino.Heranca;

public class Main {
    public static void main(String[] args) {

        Panda panda = new Panda("Panda",40,"Branco","preto");
        panda.imprimirDados();
        panda.imprimirDadosPanda();
        panda.subirArvore();

        Hipopotamo hipopotamo = new Hipopotamo("Hipopotamo",30,100);
        hipopotamo.imprimirDados();
        System.out.println("Forca da mordida: "+hipopotamo.getForcaMordida());
        System.out.println("O que o hipopotamo esta fazendo: ");
        hipopotamo.ficarNaAgua();
    }
}
