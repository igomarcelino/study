import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        // salvar caminho de dados em uma string para utilizar no File
        String caminhoCSV = "/home/igo/Dev/git/study/gitStudy/Languages/Java/SENAI/dados.csv";
        List<double[]> dados = LerArquivoCSV.lerArquivoCSV(caminhoCSV);


        //verificar se ha coeficientes nulos
        if(dados != null){
            double[] coeficientes = RegressaoLinear.RegressaoLinear(dados);
            System.out.println("Coeficiente da regressao Linear: ");
            System.out.println("Intercpto : " + coeficientes[0]);
            System.out.println("Inclinacao: " + coeficientes[1]);
            System.out.println("Rx2: " + coeficientes[2]);
            CriarGrafico.criarGrafico(dados,coeficientes);
        }else {
            System.out.println("Falha na leitura do arquivo CSV");
        }

    }

}
