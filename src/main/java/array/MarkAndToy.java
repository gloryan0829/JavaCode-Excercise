package array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MarkAndToy {


    public static void main(String[] args) {

        int[] a = {1, 12, 5, 111, 200, 1000, 10};

        int[] result = maximumToys(a, 50);

        IntStream.of(result).forEach(val -> System.out.print(val + " "));
    }

    static int[] maximumToys(int[] a, int k) {

        int lastSize = 0;
        int[] result = null;
        Arrays.sort(a, 0, a.length);

        for (int i=0; i<a.length; i++) {
            k-=a[i];
            if(k < 0) break;
            lastSize++;
        }

        result = Arrays.copyOf(a, lastSize);

        return result;
    }
}
