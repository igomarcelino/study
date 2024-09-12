package Lambda.ConceitosLambda.ComoCriarStream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CriandoStream {
    public static void main(String[] args) {
        /*
        * Stream a partir de uma List do tipo String
        * */

        List<String> itens = new ArrayList<>();
        itens.add("pao");
        itens.add("cafe");
        itens.add("leite");
        itens.add("biscoito");
        Stream<String> stream = itens.stream();

        // Criando uma Stream a partir de um map

        Map<String, Integer> integerMap = new HashMap<>();
        integerMap.put("igo", 36);
        integerMap.put("joao", 22);
        integerMap.put("Pedro", 19);

        Stream<Integer> stream2 = integerMap.values().stream();

        // Criando Stream a partir de um Array
        Stream<Integer> numberFromValues = Stream.of(1,2,3,4,5);
        IntStream numbersFromArrays = Arrays.stream(new int[]{1,2,3,4,5});

        // Criando uma stream a partir de um arquivo de texto para contar as linhas
        try {
            Stream<String> lines = Files.lines(Paths.get("caminho"),Charset.defaultCharset());
            long numbersLines = lines.count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
