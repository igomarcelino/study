package Lambda.ConceitosLambda;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class ConceitoExpressoesLambda {

    // metodo utilizando o foreach , implementado na versao 5
    // devemos nos preocupar em percorrer a colecao e interara cada valor em uma variavel
    // apos esse processo, devemos retornar essa variavel

    public static int somaInterator(List<Integer> list ){
        int sum = 0;
        for (Integer i : list){
            if (i % 2 == 0){
                sum += i;
            }
        }
        return sum;
    }

    // Abordagem no Java 7 ou anterior para trabalhar com coleções.
    public void trabalhandoComColecoes(){
        List<Ordem> ordemAtivacao = new ArrayList<>();
        for (Ordem o : ordemAtivacao){
            if (o.getServico() == "tal serico"){
                ordemAtivacao.add(o);
            }
        }
        Collections.sort(ordemAtivacao, new Comparator<Ordem>() {
            @Override
            public int compare(Ordem o1, Ordem o2) {
                return o1.getServico().compareTo(o2.getServico());
            }
        });

        List<Integer> ordensId = new ArrayList<>();
        for (Ordem o : ordemAtivacao){
            ordensId.add(o.getId());
        }
    }

    //Abordagem no Java 8 utilizando Streams para trabalhar com coleções.
    public void trabalhandoComStream(){
        List<Ordem> ordem = new ArrayList<>();

        List<Integer> ordensId = ordem.stream().
                filter(o -> o.getServico() == "tal servico").
                sorted(Comparator.comparing(Ordem::getId).reversed()).
                map(Ordem::getId).toList();

    }

    //mas e ai, o que e uma stream? sequência de elementos de uma fonte de dados que oferece suporte a diferentes tipos de operações de agregação

    public static void main(String[] args) {

    }
}
