package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;

public class ExemploAverage {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();
        // o average retorna uma media de todos os valores obtidos na pipeline
        // Por exemplo , queremos saber a idade media das pesoas que nasceram no Brasil
        double idadeMedia = pessoas.stream().filter(pessoa -> pessoa.getNacionalidade().equalsIgnoreCase("brasil")).
                            mapToInt(Pessoa::getIdade).average().getAsDouble();
        System.out.println(idadeMedia);

        // utilizamos o mapToInt() pois retornara uma stream apenas de numeros inteiros
        // ja o average() retorna um optional e o getAsDouble() e um OptionalDouble que retorna um valor em double
    }
}
