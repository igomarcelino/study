package Poli;

public class Tomato extends Produto {

    public static final double imposto = 0.21;
    public Tomato(String nome, double preco) {
        super(nome, preco);
    }

    public Tomato() {
    }


    @Override
    public double taxacao() {
        return this.preco * imposto;
    }
}
