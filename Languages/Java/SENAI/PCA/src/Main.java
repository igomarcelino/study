import org.apache.commons.math3.linear.*;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double [] [] dados = {
                {50.0, 30.0, 20.0}, // amostra 1 - argila, silte e areia
                {49.0, 30.5, 20.5}, // amostro 2 - argila, silte e areia
                {49.0, 30.0, 21.0}, // amostra 3 - argila, silte e areia
                {51.0, 29.0, 20.0}, // amostra 4 - argila, silte e areia
                {49.5, 30.0, 20.5}, // amostra 5 - argila, silte e areia
                {60.0, 20.0, 20.0}, // amostra 6 - argila, silte e areia
                {60.0, 20.0, 20.0}, // amostra 7 - argila, silte e areia
                {55.0, 14.5, 30.5}, // amostra 8 - argila, silte e areia
                {10.0, 19.5, 70.5}, // amostra 9 - argila, silte e areia
                {19.5, 60.0, 30.5}  // amostra 10 - argila, silte e areia
        };
        //cria a matrix de dados das amostras de solo
        RealMatrix matrix = MatrixUtils.createRealMatrix(dados);
        // calcular a matriz de covariancia
        RealMatrix covarianciaMatrix = new Covariance(matrix).getCovarianceMatrix();
        // calcular os autovalores e os autoveres
        EigenDecomposition eigenDecomposition = new EigenDecomposition(covarianciaMatrix);
        //Obter os autovetores - componentes principais ( CP1 e CP2 )
        RealMatrix eigenVectors = eigenDecomposition.getV();
        //Selecionar os dois primeiros componentes principais
        RealMatrix pcaComponents = eigenVectors.getSubMatrix(0,1,0,matrix.getColumnDimension());
        // projetar os dados nas componentes principais
        RealMatrix projectData = matrix.multiply(pcaComponents.transpose());
        //projecao desses daos para plotagem
        double[] [] dadosProjetados = projectData.getData();
        //determinar a serie de dados para o grafico
        XYSeries series = new XYSeries("PCA");
        for(int i = 0;i<dadosProjetados.length;i++){
            series.add(dadosProjetados[i][0], dadosProjetados[i][0]);
        }
        XYSeriesCollection dataSet = new XYSeriesCollection(series);
        //criar o nosso grafico de dispersao
        JFreeChart chart = ChartFactory.createScatterPlot(
                "PCA",
                "Componente 1",
                "Componente 2",
                dataSet,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800,600));
        JFrame frame = new JFrame("PCA Amostra de solo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
