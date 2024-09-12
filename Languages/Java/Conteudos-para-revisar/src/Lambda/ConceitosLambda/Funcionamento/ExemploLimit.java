package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;
import java.util.stream.Stream;

public class ExemploLimit {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();

        // usando o limit para limitar a quantidade de elementos dentro da stream
        Stream<Pessoa> pessoaStream = pessoas.stream().limit(2);
        // nesse caso o pipeline ira trabalhar em cima de 2 elementos apenas


    }


}
