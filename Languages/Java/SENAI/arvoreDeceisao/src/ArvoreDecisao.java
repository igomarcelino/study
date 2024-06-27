import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ArvoreDecisao {
    public static No construirArvore(String[][] dados){
        No raiz = new No("Esta chovendo?\n(Sim) ..........(Nao)");
        No no1 = new No("Esta ventando?\n(Sim) .........(Nao)");
        No no2 = new No("Esta ventando forte?\n(Sim).........(Nao)");
        No folha1 = new No("Decisao",dados[0][3]);
        No folha2 = new No("Decisao",dados[1][3]);
        No folha3 = new No("Decisao",dados[2][3]);
        No folha4 = new No("Decisao",dados[3][3]);

        raiz.definirFIlhos(no1,folha1);
        no1.definirFIlhos(no2,folha2);
        no2.definirFIlhos(folha3,folha4);

        return raiz;
    }

    private static void construirGrafico(No no ,Graph<String, DefaultEdge> grafico,Map<No,String> nos ){
        if(!nos.containsKey(no)){
            String rotulo = no.pergunta;
            if(no.decisao != null){
                rotulo += ": " + no.decisao;
            }
            grafico.addVertex(rotulo);
            nos.put(no,rotulo);
        }
        if (no.verdadeiro != null){
            construirGrafico(no.verdadeiro, grafico, nos);
            grafico.addEdge(nos.get(no),nos.get(no.verdadeiro));
        }
        if (no.falso != null){
            construirGrafico(no.falso, grafico, nos);
            grafico.addEdge(nos.get(no), nos.get(no.falso));
        }
    }
    // desnhando os vertices
    public static void desenharArvore(No raiz){
        Graph<String, DefaultEdge> grafico = new DefaultDirectedGraph<>(DefaultEdge.class);
        Map<No, String> nos = new HashMap<>();
        construirGrafico(raiz, grafico, nos);
        mxGraph mxGraph = new mxGraph();
        Object parent = mxGraph.getDefaultParent();
        mxGraph.getModel().beginUpdate();

        try{
            Map<String , Object> graficoNos = new HashMap<>();
            for (String vertex : grafico.vertexSet()){
                graficoNos.put(vertex,mxGraph.insertVertex(parent,null,vertex,20,20,200,50));
            }
            for (DefaultEdge edge : grafico.edgeSet()){
                String fonte = grafico.getEdgeSource(edge);
                String alvo = grafico.getEdgeTarget(edge);
                mxGraph.insertEdge(parent,null,"",graficoNos.get(fonte),graficoNos.get(alvo));
            }
        }finally {
            mxGraph.getModel().endUpdate();
        }

        mxCompactTreeLayout layout = new mxCompactTreeLayout(mxGraph,false);
        layout.execute(mxGraph.getDefaultParent());

        JFrame jFrame = new JFrame("Arvore de decisao");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.getContentPane().add(new mxGraphComponent(mxGraph));
        jFrame.setSize(1000,600);
        jFrame.setVisible(true);

        interacaoUsuario(raiz);

    }

    // resolucao do exercicio
    public static void interacaoUsuario(No raiz){
        No noatual = raiz;
        while (noatual.verdadeiro != null && noatual.falso!= null){
            int resposta = JOptionPane.showOptionDialog(null,noatual.pergunta.replace("\n(Sim).........(Nao)",""),
                    "Arvore decisao",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[] {"sim", "nao"},null);
            if(resposta == JOptionPane.YES_OPTION){
                noatual = noatual.verdadeiro;
            }else {
                noatual = noatual.falso;
            }
        }

        JOptionPane.showMessageDialog(null, "Decisao: " + noatual.decisao, "Resultado Decisao",JOptionPane.INFORMATION_MESSAGE);

    }
}
