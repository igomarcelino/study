import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.List;

public class CriarGrafico {
    // Criar o grafico dispersao com a reta obtida pelo metodo de regressao
    public static void criarGrafico(List<double[]> dados, double[] coeficientes){
        XYSeries series = new XYSeries("dados");
        for(double[] ponto : dados){
            series.add(ponto[0],ponto[1]);
        }
        XYSeries regresaaoLinear = new XYSeries("Linha de REgressao");
        double minX = dados.stream().mapToDouble(ponto -> ponto[0]).min().orElse(0);
        double maxX = dados.stream().mapToDouble(ponto -> ponto[0]).max().orElse(0);
        // Desenhando no grafico
        regresaaoLinear.add(minX,coeficientes[0] + coeficientes[1] * minX);
        regresaaoLinear.add(maxX,coeficientes[0] + coeficientes[1] * maxX);

        // criar a estrutura do grafico : eixos e o conteudo ( pontos de dispersao )

        XYSeriesCollection dataSet = new XYSeriesCollection();
        // pontos da planilha
        dataSet.addSeries(series);
        //reta obtida na regressao linear
        dataSet.addSeries(regresaaoLinear);

        // compor o grafico utilizando JFreeChart
        JFreeChart grafico = ChartFactory.createScatterPlot(
                "Regressao Linear",
                "Idade"
                ,"Peso"
                ,dataSet
                , PlotOrientation.VERTICAL
                ,true
                ,true
                ,false
        );
        XYPlot plotar = grafico.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(1,true);
        renderer.setSeriesShapesVisible(1,true);
        plotar.setRenderer(renderer);

        //utilizar o jframe para criar o grafico
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Grafico de Regressao Linear");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(new ChartPanel(grafico));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });


    }

    public CriarGrafico() {
    }
}
