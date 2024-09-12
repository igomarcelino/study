package Lambda.ConceitosLambda.Funcionamento;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExemploMap {
    public static void main(String[] args) {

        // Criando uma list e populando com nome de pesoas

        List<Pessoa> listPessoa = new Pessoa().populaPessoas();

        /*
        * Agora vamos criar uma Stream do tipo Integer a onde vamos percorrer
        * essa list de Pessoas e pegar todas as idades dessas pessoas
        * */

        Stream<Integer> stream = listPessoa.stream().
                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil")).
                map(Pessoa::getIdade);
                /*
                * Nesse map poderiamos ter usado da seguinte maneira
                * map(p-> p.getIdade()), o mesmo estaria retornando uma stream de integer
                * Mas podemos chamar o metodo da classe utilizando o ::, esse conceito e chamado
                * de method reference
                * */

        // outro modo de obter essa stream
        IntStream streamInt = listPessoa.stream().
                                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil")).
                                mapToInt(Pessoa::getIdade);

        // podemos tambem com o map transformar um tipo de stream em outro tipo
        List<String> pessoasNome = listPessoa.stream().
                                    filter(pessoa -> pessoa.getNacionalidade().equals("Brasil")).
                                    sorted(Comparator.comparing(Pessoa::getIdade)).
                                    map(Pessoa::getNome).toList();
    }
}
