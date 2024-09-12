package Lambda.ConceitosLambda.Funcionamento;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ExemploSorted {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();

        // Obtendo uma stream de Strings a partir da collection de pessoas
        Stream<Pessoa> stream = pessoas.stream().
                                filter(pessoa -> pessoa.getNacionalidade().equalsIgnoreCase("Brasil")).
                                sorted(Comparator.comparing(Pessoa::getNome));
                                // sendo o mesmo que sorted(Comparator.comparing(pessoa-> pessoa.getNome().compareTo(pessoa.getNome())));

    }
}
