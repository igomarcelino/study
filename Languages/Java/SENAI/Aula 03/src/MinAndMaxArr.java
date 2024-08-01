import java.util.Arrays;
import java.util.stream.Collectors;

public class MinAndMaxArr {
    public static void main(String[] args) {
       int[] a = {1, 2, 3, 4, 5};
       int[] b = {2334454,5};
       int[] c = {1};
       int[] result = minMax(c);

       for (int i : result){
           System.out.print(i+",");
       }

    }

    public static int[] minMax(int[] arr) {
        // Your awesome code here
        /*int[] minMax = new int[2];
        minMax[0] = Arrays.stream(arr).min().getAsInt();
        minMax[1] = Arrays.stream(arr).max().getAsInt();
        return minMax;*/
        Arrays.sort(arr);
        return new int[]{arr[0],arr[arr.length-1]};
    }
}
