package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;
import java.util.stream.Stream;

public class ExemploDistinct {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        // criando uma stream de pessoas e utilizando o distinct para apenas pegar
        // pessoas que sao unicas nessa list
        Stream<Pessoa> pessoaStream = pessoas.stream().distinct();

    }
}
