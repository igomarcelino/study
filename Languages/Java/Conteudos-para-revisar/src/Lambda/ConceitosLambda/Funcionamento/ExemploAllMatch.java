package Lambda.ConceitosLambda.Funcionamento;

import java.util.List;

public class ExemploAllMatch {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new Pessoa().populaPessoas();

        // utilizando o allMatch para verificar se todos elementos atendem ao predicado

        boolean todosMexicanos = pessoas.stream().
                                allMatch(pessoa -> pessoa.getNacionalidade().equalsIgnoreCase("Mexico"));
    }
}
