package stream;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperation {
    public static void main(String[] args) {

        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);

        System.out.println("abs1 == abs2 is " + (abs1 == abs2));

        /**
         * Identity Function
         * T -> T 같은 타입을 리턴한다
         * 입력 값을 받아서 그대로 리턴한다
         * 어떤 경우에 쓸까
         */
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        System.out.println(
                map(numbers, i -> i * 2)
        );

        System.out.println("-------------------");
        System.out.println(
                map(numbers, Function.identity())
        );

        /**
         * Intstream...
         *
         */
        IntStream.range(1, 10).forEach(i -> System.out.print(i + " "));
        System.out.println();
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));

        //Infinite Num...
//        IntStream.iterate(1, i -> i+1 ).forEach(i -> System.out.print(i + " "));
//        System.out.println();
//        Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE) ).forEach(i -> System.out.print(i + " "));



    }

    private static <T,R> List<R> map(final List<T> list, final Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        list.forEach(
                e -> result.add(mapper.apply(e))
        );
        return result;
    }
}
