package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Stream13 {
    public static void main(String[] args) {

        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream()
                .filter(a -> a > 3 && a < 9)
                .filter(e -> parse(e))
                .map(multiply())
                .forEach(e -> System.out.print(e + " "));

        System.out.println("\n-----------------------------------");

        int findNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
                                .stream()
                                .filter(a -> a > 10)
                                .findFirst()
                                .get();

        System.out.println("find first num greater than 10 > " + findNumber);

    }

    private static Function<Integer, Integer> multiply() {
        return num -> {
            final int a = num * 2;
            return a;
        };
    }

    private static boolean parse(Integer e) {
        return e > 1;
    }
}
