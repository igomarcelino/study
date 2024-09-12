package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;

public class ExemploCount {
    public static void main(String[] args) {
        List<String> pessoas = new Pessoa().nomePessoas();

        // o metodo count e utilizado para contar elementos em uma stream
        // ele pode ser usado depois de uma operacao intermediaria como por exemplo o filter

        long quantidadeDePessoas = pessoas.stream().
                                    filter(pessoa -> pessoa.startsWith("M")).
                                    count();

        // no caso o count retorna um long com a quantidade de elementos na stream do metodo filter
    }
}
