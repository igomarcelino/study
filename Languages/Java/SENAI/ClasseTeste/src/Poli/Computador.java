package Poli;

public class Computador extends Produto{

    public static final double imposto = 0.40;
    public Computador(String nome, double preco) {
        super(nome, preco);
    }

    public Computador() {
    }


    @Override
    public double taxacao() {
        return this.preco*imposto;
    }
}
