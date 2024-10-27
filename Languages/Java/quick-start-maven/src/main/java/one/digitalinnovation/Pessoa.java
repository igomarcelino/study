package one.digitalinnovation;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate nascimento;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa(String nome, LocalDate of) {
        this.nome = nome;
        this.nascimento = of;
        idade = LocalDate.now().getYear() - nascimento.getYear();
    }

    public boolean ehMariorDeIdade(){
        return this.idade > 18;
    }
}
