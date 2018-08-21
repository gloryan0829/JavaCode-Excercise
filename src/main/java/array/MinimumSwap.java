package array;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinimumSwap {

    public static void main(String[] args) {

        int[] a = {1, 5, 3, 4};
        Swap swap = new Swap();
        System.out.println(swap.swapNum(a));
    }

    private static class Swap {

        public int swapNum(int[] a) {
            int swap=0;
            for(int i=0;i<a.length;i++){
                if(i+1!=a[i]){
                    int t=i;
                    while(a[t]!=i+1){
                        t++;
                    }
                    int temp=a[t];
                    a[t]=a[i];
                    a[i]=temp;
                    swap++;
                }
            }
            return swap;
        }
    }
}
