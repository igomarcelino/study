import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;

public class Main {
    public static void main(String[] args) {
        // Base de dados sobre audiencia nos filmes
        List<Filme> filmes = new ArrayList<Filme>();
        filmes.add(new Filme("Acao" ,"Sim","Boa" ));
        filmes.add(new Filme("Acao", "Nao", "Ruim"));
        filmes.add(new Filme("Comedia", "Sin", "Boa"));
        filmes.add(new Filme("Comedia", "Sim","Ruim"));
        filmes.add(new Filme("Comedia", "Nao","Boa"));

        //calcular a entropia do conjunto inicial
        double entropiaInicial = calcularEntropia(filmes);
        System.out.println("Entropia Inicial = " + entropiaInicial);
        // Entropia por atributo ( escolha genero )
        String atributoDIvisao = "Genero";
        Map<String, List<Filme>> subdivisoes = dividirPorAtributo(filmes,atributoDIvisao);

        for(Map.Entry<String,List<Filme>> entry : subdivisoes.entrySet()){
            String valorAtributo = entry.getKey();
            List<Filme> sub = entry.getValue();
            double entropiaSub = calcularEntropia(sub);
            System.out.println("Entropia apos dividir por: " + atributoDIvisao + " =" + valorAtributo + ": " + entropiaSub);
        }

    }

    //Definindo a classe Filme
    static class Filme{
        String genero;
        String atoresFamosos;
        String qualidade;
        public Filme(String genero, String atoresFamosos, String qualidade){
            this.genero = genero;
            this.atoresFamosos = atoresFamosos;
            this.qualidade = qualidade;
        }
    }

    public static double calcularEntropia(List<Filme> filmes){
        int total = filmes.size();
        Map<String, Integer> contagemClasses = new HashMap<>();
        for (Filme filme : filmes){
            String classe = filme.qualidade; // Atributo Alvo
            contagemClasses.put(classe,contagemClasses.getOrDefault(classe,0)+1);
        }
        //Calcular a Entropia
        double entropia = 0.0;
        for (Map.Entry<String, Integer> entry : contagemClasses.entrySet()){
            double probabilidade = (double) entry.getValue() / total ;
            entropia -= probabilidade * Math.log(probabilidade) / Math.log(2);
        }
        return entropia;
    }

    // definir um metodo para dividir os dados por atributo especifico ( ex: o proprio genero )
    public static Map<String,List<Filme>> dividirPorAtributo(List<Filme> filmes, String atributo){
        Map<String, List<Filme>> subdivisoes = new HashMap<>();
        for(Filme filme : filmes){
            String valorDoAtributo = null;
            switch (atributo){
                case "Genero":
                    valorDoAtributo = filme.genero;
                    break;
                case "Atores Famosos":
                    valorDoAtributo = filme.atoresFamosos;
                    break;
            }
            if (!subdivisoes.containsKey(valorDoAtributo)){
                subdivisoes.put(valorDoAtributo,new ArrayList<>());
            }
                subdivisoes.get(valorDoAtributo).add(filme);

        }
        return subdivisoes;
    }


}
