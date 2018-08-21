package hash;


import java.util.*;
import java.util.stream.Collectors;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {

        long result = 0;
        Map<Long, List<Long>> numberToIndices = new HashMap<>();

        for (int i = 0; i < arr.size(); i++){
            if(!numberToIndices.containsKey(arr.get(i))) {
                numberToIndices.put(arr.get(i), new ArrayList<>());
            }
        }

        for (int i = 0; i < arr.size(); i++) {

            if(arr.get(i) % r != 0) {
                continue;
            }

            long firstNumber = arr.get(i) / r;

            long lastNumber = arr.get(i) * r;

            System.out.println(i + " >> " + firstNumber + " / " + lastNumber);
//            result +=
        }


        return result;
    }

    public static void main(String[] args) {


        List<Long> arr = Arrays.asList(1L,5L,5L,25L,125L);
        long r = 5L;

        long result = CountTriplets.countTriplets(arr, r);

    }
}
