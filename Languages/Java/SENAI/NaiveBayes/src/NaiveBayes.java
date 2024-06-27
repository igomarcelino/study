import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class NaiveBayes {
    // definir um modelo de classificacao que utiliza como recurso a inferencia bayesiana
    // O Algoritmo gera uma tabela de probabiliades para a classificacao.

    //Realizar a contagem de palavras para e-mails de spam
    private Map<String,Integer> spamContarPalavras;

    //Contagem de palavras para e-mails de ham ( nao spam )
    private Map<String,Integer> hamContarPalavras;

    //Vocabulario
    private Set<String> vocabulario;

    //Total de e-mails de spam
    private int spamQuantidade;

    //total de e-mails de ham
    private int hamQuantidade;

    public NaiveBayes(){
        spamContarPalavras = new HashMap<>();
        hamContarPalavras = new HashMap<>();
        vocabulario = new HashSet<>();
        spamQuantidade = 0;
        hamQuantidade = 0;
    }

    /*
    * O Metodo abaixo reve dados para o treino , na forma de uma matriz
    * de strings, onde cada entrada consiste de um rotulo ( spam ou ham) e
    * o texto de e-mail
    * */
    public void treino(String[][] treinandoDados){
        for(String[] email : treinandoDados){
            String rotulo = email[0];
            // Dividir o texto em palavras
            String[] palavras = email[1].split("\\s+".toLowerCase());
            // Atualizar a contagem de palavras
            //adiciona os spam
            if(rotulo.equals("cinema")) {
                spamQuantidade++;
                for (String palavra : palavras) {
                    spamContarPalavras.put(palavra, spamContarPalavras.
                            getOrDefault(palavra, 0) + 1);
                    vocabulario.add(palavra);
                }
            }else{// adiciona os ham
                hamQuantidade++;
                for (String palavra : palavras){
                        hamContarPalavras.put(palavra,hamContarPalavras.
                                getOrDefault(palavra,0)+1);
                        vocabulario.add(palavra);
                }
            }
        }
    }
    // Criar o metodo para classificar o e-mail, utilizando a
    //probabilidade ( suavizacao de laplace ) . Sera considerado
    //spam , caso a pontucao obtida no provesso seja maior ou
    //igual a pontuacao de ham caso contratio sera ham .
    public String classificar(String email){
        String[] palavras = email.split("\\s+");
        double spamPontos = Math.log((double) spamQuantidade / (spamQuantidade + hamQuantidade));
        double hamPontos = Math.log((double) hamQuantidade / (spamQuantidade + hamQuantidade));

        for (String palavra : palavras){
            //calcular a probabilidade condicional usando a
            // Suavizacao de laplace
            if(vocabulario.contains(palavra)){
                double spamProb = (spamContarPalavras.getOrDefault(palavra,0)+1)/(spamQuantidade + vocabulario.size());
                double hamProb = (hamContarPalavras.getOrDefault(palavra,0)+1 / (hamQuantidade + vocabulario.size()));
                spamPontos += Math.log(spamProb);
                spamPontos += Math.log(hamProb);
            }
        }
        //Definir se e spam ou ham
        return spamPontos >= hamPontos ? "cinema" : "musica" ;
    }

}
