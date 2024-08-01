import java.util.Arrays;
import java.util.stream.Collectors;
/*
* @Transforma toda primeira letra de cada palavra em maiuscula.
* Para transformar em minuscula , basta trocar o toUpperCase() para o toLowerCase()
* */
import static java.util.Arrays.stream;

public class JadenCasingStrings {

    public static void main(String[] args) {

        String phrase = "a new world is better than a old world";
        String newWord = lowToUpper(phrase);
        System.out.println(newWord);
    }

    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment



        return Arrays.stream(phrase.split(" ")).
                map(x-> x.substring(0,1).toUpperCase().
                        concat(x.substring(1))).
                        collect(Collectors.joining(" "));
    }

    public static String lowToUpper(String word){
        if(word != null && word != ""){
            String[] newWord = word.split(" ");
            String lowToUp = "";
            for (String s : newWord){
                lowToUp += s.substring(0,1).toUpperCase().concat(s.substring(1)).concat(" ");
            }
            return lowToUp.trim();
        } else  {
            return null;
        }

    }
}
