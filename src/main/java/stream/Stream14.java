package stream;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Stream14 {
    public static void main(String[] args) {


        System.out.println(
            Stream.of(1,2,3,4,5,6)
                    .filter(i -> i > 2)
                    .map(i -> i * 2) // lazy Evaluation...
                    .map(i -> "# " + i)
                    .collect(toList())
        );

        System.out.println(
                Stream.of(1,3,3,4,5,5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "# " + i)
                .collect(toSet())
        );

        System.out.println(
                Stream.of(1,3,3,4,5,5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .collect(joining(", "))
        );

        System.out.println(
                Stream.of(1,3,3,4,5,5)
                .filter(i -> i > 2)
                .map(i -> i * 2)
                .map(i -> "#" + i)
                .distinct()
                .collect(joining(", ", "[", "]"))
        );
    }
}
