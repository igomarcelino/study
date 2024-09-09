package Comparable_Comparator;


import java.util.*;

public class ExemploComparable{

    private List<Pessoas> pessoasList;

    public ExemploComparable(){
        this.pessoasList = new ArrayList<>();
    }

    public void adicionarPessoas(String nome, int idade){
        pessoasList.add(new Pessoas(nome, idade));
    }
    public void imprimirPessoas(){
        System.out.println(pessoasList);
    }

    public List<Pessoas> pessoaPorIdade(){
        List<Pessoas> ordenaPorIdade = new ArrayList<>(pessoasList);
        Collections.sort(ordenaPorIdade);
        return ordenaPorIdade;
    }
    public List<Pessoas> pessoasPorNome(){
        List<Pessoas> ordenarPorNome = new ArrayList<>(pessoasList);
        Collections.sort(ordenarPorNome,new comparatorPorNome());
        return ordenarPorNome;
    }

    public static void main(String[] args) {
        ExemploComparable exemploComparable = new ExemploComparable();
        exemploComparable.adicionarPessoas("Joao", 24);
        exemploComparable.adicionarPessoas("Aline", 21);
        exemploComparable.adicionarPessoas("Lucas", 16);
        exemploComparable.adicionarPessoas("Maria", 20);
        exemploComparable.adicionarPessoas("Marcia", 34);

        System.out.println("Lista de pessoas na ordem em que horam inseridas ");
        exemploComparable.imprimirPessoas();
        System.out.println("-----------------------------------------------");
        System.out.println("Pessoas ordenadas por idade: " + exemploComparable.pessoaPorIdade());
        System.out.println("-----------------------------------------------");
        System.out.println("Pessoas por ordem alfabetica: "+ exemploComparable.pessoasPorNome());

    }



}

class Pessoas implements Comparable<Pessoas>{
    private String nome;
    private int idade;

    public Pessoas(){

    }

    public Pessoas(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    // metodo comparable
    @Override
    public int compareTo(Pessoas o) {
        return Integer.compare(idade,o.getIdade());
    }
    /**
     * Ja olhando para o comparable vemos que ele utiliza um tipo para comparacao , e ira utilizar atributos da propria
     * classe para fazer a comparacao , utilizando o mesmo retorno -1, 0, 1
     * quando passamos um sort em uma lista para um tipo generico, temos de ter certeza que esse tipo teve a implementacao
     * do comparable na sua classe. pois o sort() e um metodo que espera que o tipo a ser comparado possua uma implementacao
     * da interface comparable.
     * */
}
/**
 * Comparator nao faz alteracoes na classe, ou seja, o comparator e uma classe externa que esta recebendo um tipo
 *  ele pega esse tipo e ira retornar um int ( -1, 0 , 1 ) do valor que esta sendo comparado
 *  na lógica ele faz o seguinte, temos os valores
 *  Temos pessoa1 com 30 anos de idade e pessoa2 com 24 anos
 *  Caso quisermos criar uma lista que ordena a idade de forma ascendente o comparator ira fazer o seguinte
 *  compare(pessoa1.idade com pessoa2.idade caso pessoa2 for mais velha retorne 1 pois pessoa1 deve estar a frente
 *  de pessoa2, caso pessoa2 for mais nova que pessoa1 retorne -1 entao, caso tenham a mesma idade retorne 0, seguindo
 *  essa logica temos o seguinte -1,0,1 entao p1 se comparando com p2 da -1 pois p2 e mais novo que p1 entao seguindo
 *  o retorno do comparator sabemos que p2 tem de vir antes de p1
 */

class comparatorPorNome implements Comparator<Pessoas>{

    @Override
    public int compare(Pessoas p1, Pessoas p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}


