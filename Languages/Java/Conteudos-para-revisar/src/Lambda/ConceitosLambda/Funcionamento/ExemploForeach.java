package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;

public class ExemploForeach {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        pessoas.stream().forEach(pessoa -> System.out.println(pessoa.getNome()));

        // O metodo forEach(Consumer<super> action) ou seja , ele e um metodo de saida
        // pois espera que seja executada uma acao para cada acao do consumer

        System.out.println("Nome antes do foreach: "+pessoas);
        pessoas.stream().forEach(pessoa -> pessoa.setNome("Novo nome"));
        System.out.println("Nome depois do foreach"+pessoas);
    }
}
