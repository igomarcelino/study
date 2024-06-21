import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivoCSV {

    // Definindo a leitura de nosso arquivo CSV
    public static List<double[]> lerArquivoCSV(String caminho)  {
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
        }catch (CsvValidationException | NumberFormatException | IOException f){
            f.printStackTrace();
        }
        // retornando a lista com os dados obetidos a partir de um csv informado
        return dados;
    }

    public LerArquivoCSV() {
    }
}
