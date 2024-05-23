package estudos.wrappers;

import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.lerArquivoTexto();



    }
    public void criarArquivo() throws IOException {

            File arquivo = new File("/home/igo/Dev/arquivo.txt");
            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);


           writer.write("Mensagem aleatoria");
           writer.write("\nLinha nova para ser digitada");
           writer.close();

           System.out.println("Caminho do arquivo: "+ arquivo.getAbsolutePath());


    }
    public void lerArquivos() throws IOException {
        File arquivoLeitura = new File("/home/igo/Dev/novoArquivo.txt");

        File arquivo = new File("/home/igo/Dev/arquivoNovoScanner.txt");
        FileWriter fileWriter = new FileWriter(arquivo);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        Scanner teclado = new Scanner(arquivoLeitura);
        while (teclado.hasNext()){
            writer.write(teclado.nextLine()+"\n");
        }


        writer.flush();
        writer.close();

    }

    public void lerArquivoTexto() throws IOException {
        File arquivoLeitura = new File("/home/igo/Dev/novoArquivo.txt");
        BufferedReader reader = new BufferedReader(new FileReader(arquivoLeitura)){};
        String linha;
        while ((linha = reader.readLine()) != null){
            System.out.println(reader.readLine());
        }
    }

}





