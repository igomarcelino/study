package io.github.igomarcelino.empresa;

public abstract class Funcionario {  // classe abstrata , nao pode receber uma instancia de objeto

    private String nome;
    private String cpf;

    private double salaraio;

    public double calcularBonificacao(){
        return  (salaraio / 10) + 50;
    }

    public abstract double imprimirSalario(); // metodo abstrato , e necessario que a classe herdada implemente esse metodo.


    public double getSalaraio() {
        return salaraio;
    }

    public void setSalaraio(double salaraio) {
        this.salaraio = salaraio;
    }

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, double salaraio) {
        this.nome = nome;
        this.cpf = cpf;
        this.salaraio = salaraio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;

        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        return getCpf() != null ? getCpf().equals(that.getCpf()) : that.getCpf() == null;
    }

    @Override
    public int hashCode() {
        int result = getNome() != null ? getNome().hashCode() : 0;
        result = 31 * result + (getCpf() != null ? getCpf().hashCode() : 0);
        return result;
    }
}
