package Poli;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KataTest {
    public static void main(String[] args) {

        boolean matches = isAnagram("Buckethead","DeathCubeK");


        System.out.println(matches);
    }

    public static boolean isAnagram(String a, String b) {
        String first = Stream.of(a.toLowerCase().split("")).sorted().collect(Collectors.joining());
        String second = Stream.of(b.toLowerCase().split("")).sorted().collect(Collectors.joining());
        return first.equalsIgnoreCase(second);
    }
}


