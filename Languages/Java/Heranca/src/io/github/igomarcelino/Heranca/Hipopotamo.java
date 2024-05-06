package io.github.igomarcelino.Heranca;

public class Hipopotamo extends Animal{

    private int forcaMordida;

    public void ficarNaAgua(){
        System.out.println("Estou na agua...");
    }

    public Hipopotamo(String nome, int idade, int forcaMordida){
        super(nome, idade);
        this.forcaMordida = forcaMordida;
    }

    public Hipopotamo(){

    }

    public int getForcaMordida() {
        return this.forcaMordida;
    }

    public void setForcaMordida(int forcaMordida) {
        this.forcaMordida = forcaMordida;
    }


}
