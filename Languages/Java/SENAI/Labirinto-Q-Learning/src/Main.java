import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {

    private static final int LARGURA = 600;
    private static final int ALTURA = 600;
    private static final int COLUNAS = 20;
    private static final int LINHAS = 20;
    private static final int CELULA_TAMANHO = LARGURA / COLUNAS;

    private static final int LABIRINTO [][] = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1},
            {1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private static final int INICIO_LINHA = 1;
    private static final int INICIO_COLUNA = 1;
    private static final int FIM_LINHA = 8;
    private static final int FIM_COLUNA = 18;
    // parametros do Q-Learning
    private static final double ALPHA = 0.1;
    private static final double GAMA = 0.9;
    private static final double EPSILON = 0.1;
    private static final int EPISODIOS = 1000;
    private double q[][];
    private int[] caminho;
    private int caminhoIndice;

    public Main(){
        setTitle("Q-Learning - Labirinto");
        setSize(LARGURA,ALTURA);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        q = new double[LINHAS * COLUNAS][4];
        caminho = new int[LINHAS * COLUNAS];
        treino();
        encontrarCaminho();
    }

    public void treino(){
        Random aleatorio = new Random();
        for (int episodio = 0; episodio < EPISODIOS ; episodio++){
            int estado = INICIO_LINHA * COLUNAS + INICIO_COLUNA;
            while (true){
                int acao;
                if (aleatorio.nextDouble() < EPSILON){
                    acao = aleatorio.nextInt(4);
                }else {
                    acao = maxAcoes(estado);
                }
                int novoEstado = obterNovoEstado(estado,acao);
                int recompensa = obterRecompensa(novoEstado);
                double maxQ = q[novoEstado][maxAcoes(novoEstado)];
                q[estado][acao] += ALPHA * ( recompensa + GAMA * maxQ - q[estado][acao]);
                estado = novoEstado;
                if (estado == FIM_LINHA * COLUNAS + FIM_COLUNA){
                    break;
                }
            }
        }
    }

    public void encontrarCaminho(){
        int estado = INICIO_LINHA * COLUNAS + INICIO_COLUNA;
        caminhoIndice = 0;
        while (estado != FIM_LINHA * COLUNAS + FIM_COLUNA){
            int acao = maxAcoes(estado);
            caminho[caminhoIndice++] = estado;
            estado = obterNovoEstado(estado,acao);
        }
        caminho[caminhoIndice] = FIM_LINHA * COLUNAS + FIM_COLUNA;
    }

    private int obterNovoEstado(int estado, int acao){
        int linha = estado / COLUNAS;
        int coluna = estado % COLUNAS;
        switch (acao){
            case 0:
                linha--;
                break;
                // vai para cima
            case 1:
                coluna++;
                break;
                // vai para direita
            case 2:
                linha++;
                break;
                //vai para baixo
            case 3:
                coluna--;
                break;
                //vai para esquerda
        }
        if (LABIRINTO[linha][coluna] == 1){
            return estado;
        }
        return linha * COLUNAS + coluna;
    }

    private int obterRecompensa(int estado){
        if (estado == FIM_LINHA * COLUNAS + FIM_COLUNA){
            return 100;
        }
        return -1;
    }

    private int maxAcoes(int estado){
        int melhorAcao = 0;
        double maxQ = q[estado][0];
        for (int i = 1; i < 4; i++){
            if (q[estado][i] > maxQ){
                maxQ = q[estado][i];
                melhorAcao = i;
            }
        }
        return melhorAcao;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (int linha = 0; linha < LINHAS; linha++){
            for (int coluna = 0 ; coluna < COLUNAS; coluna++){
                if (LABIRINTO[linha][coluna] == 1){
                    g.setColor(Color.BLACK);
                }else {
                    g.setColor(Color.white);
                }
                g.fillRect(coluna * CELULA_TAMANHO, linha * CELULA_TAMANHO, CELULA_TAMANHO, CELULA_TAMANHO);
            }
        }

        g.setColor(Color.BLUE);
        for (int i = 0 ; i <= caminhoIndice; i++){
            int linha = caminho[i] / COLUNAS;
            int coluna = caminho[i] % COLUNAS;
            g.fillRect(coluna*CELULA_TAMANHO,linha*CELULA_TAMANHO,CELULA_TAMANHO,CELULA_TAMANHO);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
 }
