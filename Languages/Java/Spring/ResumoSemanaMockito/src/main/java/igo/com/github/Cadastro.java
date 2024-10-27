package igo.com.github;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {
    // atributos da classe cadastro
    private Pessoa pessoa;
    private List<Pessoa> pessoaList;

    // construtor vazio que inicializa a classe pessoa
    public Cadastro(){
        this.pessoaList = new ArrayList<>();
    }

    // metodo para cadastrar uma pessoa
    public Pessoa cadastrarPessoa(){
        pessoa = new Pessoa();
        pessoa.setNome("Ciclano");
        pessoa.setCpf("12332112311");
        pessoa.setTelefone("1333221122");
        return pessoa;
    }

    // metodo para guardar essa pessoa na lista
    public void adicioarPessoas(Pessoa pessoa){
        pessoaList.add(pessoa);
        System.out.println("Pessoa adicionada.");
    }

    public List<Pessoa> listaPessoa(){
        return pessoaList;
    }

}
