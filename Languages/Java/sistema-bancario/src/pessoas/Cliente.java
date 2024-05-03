package pessoas;

public class Cliente {
    public String cpf ;
    public String nome;

    public Cliente(){// Construtor vazio , ja vem por padrao nas classes

    }

    public Cliente(String cpf, String nome){ // Construtor com argumentos
        this.cpf = cpf;
        this.nome = nome;
    }

}
