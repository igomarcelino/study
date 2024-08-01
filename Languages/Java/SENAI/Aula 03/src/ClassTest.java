import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassTest {

    // converter long em reverso int[]
    public static void main(String[] args) {
       B classB = new B(2);
        System.out.println(B.x + B.y + B.z);
    }
    public static String countingSheep(int num) {
        //Add your code here
        return IntStream.range(1,num+1).mapToObj(a-> ""+a+" sheep...").collect(Collectors.joining());
    }

    public static int grow(int[] x){
        return Arrays.stream(x).reduce(1,(a,b) -> a*b);

    }

    public static boolean  isIsogram(String str) {
        // ... utilizando distinct() para verificar se a algum elemento distinto dentro da stream
        return str.toLowerCase().length() == str.chars().distinct().count();

    }

    public static List<Object> filter(List<Object> list){
        return list.stream().filter(x-> x instanceof Integer).collect(Collectors.toList());
    }

    public static int[] convertLong(long l){
        String[] nums = new StringBuilder(String.valueOf(l)).reverse().toString().split("");

        int[] result = new int[nums.length];

        for(int i  = 0; i< nums.length; i++){
            result[i] = Integer.parseInt(nums[i]);
        }
        return result;
    }

    static class M{
        static int x= 10, y=10,z=10;
    }
    static class B extends M{

        public B(int i) {
            super();
        }
    }
}
