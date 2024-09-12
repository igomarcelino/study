package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;
import java.util.stream.Collectors;

public class ExemploCollect {
    public static void main(String[] args) {
        List<String> pessoas = new Pessoa().nomePessoas();
        //usando o collect possibilita coletar elementos de uma lista e transformarr
        //esses elementos em uma colecao ( List, Set, Map )

        List<String> nomePessoas = pessoas.stream().
                    filter(pessoa -> pessoa.startsWith("M")).
                    collect(Collectors.toList());
    }
}
