package java8;


import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamEx1 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 10).forEach( i -> System.out.println(i));
        IntStream.iterate(1, i -> i + 1).forEach(i -> System.out.print(i + " "));

//        Stream.of(1,2,3,4,5).forEach(i -> System.out.print(i + " "));

//        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    }
}
