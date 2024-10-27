package Poli;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ClassTest {
    public static void main(String[] args) {

      
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] numbers = {0,0};
        for (int i = 0; i < nums.length -1 ; i++){
            for (int j = i+1;j <= nums.length -1 ;j++){
                if (nums[i] + nums[j] == target){
                    numbers[0] = i;
                    numbers[1] = j;
                }
            }
        }
        return numbers;
    }

    public static long sumTwoSmallestNumbers(final long[] numbers) {
        //Your solution here
        return 1L;

    }

    public static int getCount(String str) {

        return str.replaceAll("[^aeiou]", "").length();
    }

    public static int squareDigits(int n) {
        String unit = String.valueOf(n);
        String result = "";
        for (int i = 0; i < unit.length(); i++) {
            int j = Character.getNumericValue(unit.charAt(i));
            j = (int) Math.pow(j, 2);
            result += String.valueOf(j);
        }

        return Integer.valueOf(result); // TODO Implement me
    }

    public static boolean isAlt(String word) {
        //make note that 'y' should not be treated as vowel
        //your code here
//        boolean repeat = false ;
//        for (int i =0; i < word.length() -1;i++){
//            if (word.charAt(i) == word.charAt(i+1)){
//                repeat = true;
//                break;
//            }
//        }
//        return repeat;
        return word.matches("[\\w]\1+");
    }

    public static int[] between(int a, int b) {
        // your code here
        return IntStream.range(a, b).toArray();
    }

    public static boolean quadradoPerfeito(int n) {
        int teste = (int) Math.sqrt(n);
        return teste * teste == n;
    }
    public static boolean fibonaci(int n){
        return quadradoPerfeito(5*(n*n)+4) | quadradoPerfeito(5*(n*n)-4);
    }

    public static String fibo(int numero){
        int a = 0;
        int b =1;
        boolean found = false;
        for (int i =0;i <= numero; i=b){
            i = a + b;
            a=b;
            b = i;
            if (i == numero || numero == 0){
                found = true;
                break;
            }
        }
        return found == true ? "O numero " + numero + " pertence a fibonacci" : "O numero " + numero + " nao pertence a fibonacci";
    }



}
