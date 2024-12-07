package Poli;

import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise {
    public static void main(String[] args) {
    String original = "The quick brown fox jumps over the lazy dog.";

    String newString = reverseWords(original);

        System.out.println(newString);
    }

    public static String reverseWords(final String original) {
        // Have at it


        return Arrays.stream(original.split("(?<=\\s)|(?=\\s+)")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining());
    }
}
