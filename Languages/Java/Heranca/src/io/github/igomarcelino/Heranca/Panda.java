package io.github.igomarcelino.Heranca;

public class Panda extends  Animal{

    private String cor;
    private String corSegundaria;

    public void imprimirDadosPanda(){
        System.out.println("Cor: " + this.getCor());
        System.out.println("Cor segundaria " + this.getCorSegundaria());
    }

    public Panda() {
    }

    public Panda(String nome, int idade, String cor, String corSegundaria) {
        super(nome, idade); // construtor herdado da classe pai
        this.cor = cor;
        this.corSegundaria = corSegundaria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCorSegundaria() {
        return corSegundaria;
    }

    public void setCorSegundaria(String corSegundaria) {
        this.corSegundaria = corSegundaria;
    }

    public void subirArvore(){
        System.out.println("Subindo...");
    }
}
