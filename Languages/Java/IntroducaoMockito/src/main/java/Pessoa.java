import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate nascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, LocalDate nascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void saudarPessoa(){
        System.out.println("Seja bem vindo " + this.nome);
    }
}
