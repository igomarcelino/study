import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.jfree.data.xy.XYSeries;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // salvar caminho de dados em uma string para utilizar no File
        String caminhoCSV = "/home/igo/Dev/git/gitStudy/Languages/Java/SENAI/dados.csv";
        List<double[]> dados = lerArquivoCSV(caminhoCSV);

        //verificar se ha coeficientes nulos
        if(dados != null){
            double[] coeficientes = RegressaoLinear(dados);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }

    }

    // Definindo a leitura de nosso arquivo CSV
    private static List<double[]> lerArquivoCSV(String caminho)  {
        // Lista para receber os dados
        List<double[]> dados = new ArrayList<>();

        try {

            CSVReader ler = new CSVReaderBuilder(new FileReader(caminho)).
                    withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();
            boolean primeiraLinha = true;

            //verificando se a proxima linha contem algo
            String[] proximaLinha;
            while ((proximaLinha = ler.readNext()) != null) {
                //pular a primeira linha ( linha do rotulo )

                if(primeiraLinha){
                    primeiraLinha = false;
                    continue;
                }

                // ignora a primeira linha
                double x = Double.parseDouble(proximaLinha[0].trim());
                double y = Double.parseDouble(proximaLinha[1].trim());

                // adicionando valores na lista
                dados.add(new double[]{x,y});
            }
            // tratando as Excepetion
        }catch ( CsvValidationException | NumberFormatException | IOException f){
            f.printStackTrace();
        }
        // retornando a lista com os dados obetidos a partir de um csv informado
        return dados;
    }

    // Criar o metodo para construir uma equacao por regressao linear

    private static double[] RegressaoLinear(List<double[]> dados){
        // declarando variavel para armazenar o tamanho dos dados
        int n = dados.size();
        // definindo variaveis para armazenar nossas somas
        double somaX = 0,somaY = 0, somaXY = 0, somaX2 = 0;
        for(double[] ponto : dados){
            double x = ponto[0];
            double y = ponto[1];
            somaX += x;
            somaY += y;
            somaXY += x * y;
            somaX2 += x * x;
        }
        // pegando a inclinacao
        double inclinacao = ( n * somaXY - somaX * somaY) / ( n * somaX2 - somaX * somaX);
        double intercepto = ( somaY - inclinacao * somaX) / n;
        // Calcular o Rx2
        double yMedio = somaY / n ;
        double SQT = 0;
        double SQR = 0;
        for (double[] ponto : dados){
            double x = ponto[0];
            double y = ponto[1];
            double yPredito = intercepto + inclinacao * x;
            SQT += Math.pow(y - yMedio,2);
            SQR += Math.pow(y - yPredito,2);
        }
        double rQuadrado = 1 - ( SQR / SQT);
        return new double[]{intercepto,inclinacao,rQuadrado};
    }

    // Criar o grafico dispersao com a reta obtida pelo metodo de regressao
    private  static void criarGrafico(List<double[]> dados, double[] coeficientes){
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
    }
}
