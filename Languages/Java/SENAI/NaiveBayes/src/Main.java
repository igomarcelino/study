import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // metodo simple naive Bayes Classifier
        NaiveBayes naiveBayes = new NaiveBayes();

        // dados para treino
        String[][] dadosTreino = {
                {"spam" , "dinheiro facil, clique aqui!"},
                {"spam","divida ativa, use o link abaixo"},
                {"spam", "100% garantido. Baixe agora"},
                {"spam","videos calientes"},
                {"ham","Ola, tudo bem?"},
                {"ham","reuniao , dia 25 de junho"},
                {"ham","Atividade de java"},
                {"ham","trabanho escolar"}
        };
        String[][] dados = {
                {"cinema", "oscar, melhor filme, atuacao, premio"},
                {"cinema", "diretor, estilo unico, filme, inovador"},
                {"cinema", "trilha sonora, maestro, musica, composicao"},
                {"cinema", "efeitos visuais, ficcao cientifica, impressionante, tecnologia"},
                {"cinema", "roteiro, adaptacao, best-seller, narrativa"},
                {"cinema", "documentario, visao profunda, tema, educativo"},
                {"cinema", "cinematografia, deslumbrante, visual, fotografia"},
                {"cinema", "drama, atuacao, personagens, intensidade"},
                {"cinema", "animacao, popular, familia, entretenimento"},
                {"cinema", "trailer, lancamento, expectativa, promocao"},
                {"musica", "album, lancamento, sucesso, banda"},
                {"musica", "festival, musica, fas, evento"},
                {"musica", "melodia, cativante, cancao, composicao"},
                {"musica", "concerto, ao vivo, energia, performance"},
                {"musica", "letra, emocional, profunda, significado"},
                {"musica", "guitarra, solo, espetacular, instrumental"},
                {"musica", "vocais, harmoniosos, execucao, arranjos"},
                {"musica", "genero, popularidade, tendencia, musica"},
                {"musica", "cantor, voz, poderosa, emotiva"},
                {"musica", "producao, estudio, gravacao, qualidade"}
        };




        // encaminhar para analise
        /*naiveBayes.trieno(dadosTreino);
        String testeEmail = "python e melhor que java";
        String resultado = naiveBayes.classificar(testeEmail);
        System.out.println("Resultado da classificacao para \"" + testeEmail + "\": " + resultado);// essa barra serve para chamar o conteudo de uma string
*/
        naiveBayes.treino(dados);
        String conteudo = JOptionPane.showInputDialog("Informe sua mensagem");
        String resultado = naiveBayes.classificar(conteudo);
        JOptionPane.showMessageDialog(null,resultado);


    }

}
