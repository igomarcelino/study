package Poli;

public class Test {
    public static void main(String[] args) {

        boolean result = isSquare(25);
        System.out.println(result);
    }
    public static boolean isSquare(int n) {

        double a = Math.sqrt(n);
        return Math.sqrt(n) % 1 == 0;

    }
}
