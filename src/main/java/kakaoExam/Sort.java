package kakaoExam;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Sort {

    public static void run(int[] arr) {
        final Map<Integer, Long> counts = IntStream
                .of(arr)
                .boxed()
                .collect(groupingBy(i -> i, counting()));

        counts.entrySet()
                .stream()
                .sorted(occurrenceAscAndValueAscSorter())
                .forEach(printer());
    }

    private static Comparator<Map.Entry<Integer, Long>> occurrenceAscAndValueAscSorter() {

        return (e1, e2) -> {
            if (e1.getValue().equals(e2.getValue()))
                return e1.getKey().compareTo(e2.getKey());
            return e1.getValue().compareTo(e2.getValue());
        };
    }

    private static Consumer<Map.Entry<Integer, Long>> printer() {

        return e -> {
            for (int i = 0; i < e.getValue(); i++) {
                System.out.println(e.getKey());
            }
        };
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,7,7,5,7};
        Sort.run(input);
    }
}