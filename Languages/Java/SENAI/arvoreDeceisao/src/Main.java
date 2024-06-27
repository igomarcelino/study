public class Main {
    public static void main(String[] args) {
        // Definir os dados da arvore

        String[][] dados = {
                {"nao", "nao","nao", "nao levar guarda-chuva"}, // folha 1 aqui temos 2 nao para poder manter a simetria de dados
                {"sim", "nao","nao", "levar capa de chuva"},// folha 2
                {"sim", "sim","sim", "va de carro"}, // folha 3
                {"sim","sim","nao","levar capa"}
        };

        //criar arvore de decisao
        No raiz = ArvoreDecisao.construirArvore(dados);
        //desenhar a arvore e exibir
        ArvoreDecisao.desenharArvore(raiz);
    }
}