package java8;

import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuntionalInterfaceExamples {

    public static void main(String[] args) {

        Function<String,Integer> toInt = value -> Integer.parseInt(value);

        final Integer number = toInt.apply("100");
        System.out.println("number > " + number);

        Function<Integer,Integer> identity = t -> t;

        System.out.println("number (identity function) : " + identity.apply(99));

        Consumer<String> print = s -> System.out.println(s);

        print.accept("Hello");

        List<Integer> numbers = Arrays.asList(-5,-4,-3,-2,-1,0,1,2,3,4,5);

        final Supplier<String> helloSupplier = () -> "Hello ";

        System.out.println(helloSupplier.get() + "world");




        Predicate<String> p = s -> s.equals("a");

        System.out.println("Predicate test > " + p.test("b"));

        println(1, 2, 3, (i1, i2, i3) -> String.valueOf((i1 + i2 + i3)));

        println("Area is ", 12, 20, (message, length, width) -> message + (length * width));

        println(1L, "Kevin", "test@email.com",
                (id, name, email) -> "User info : ID=" + id + ", name=" + name + ", email=" + email);

        long start = System.currentTimeMillis();
        printIfValidIndex(9, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        System.out.println("times(s) : " + (System.currentTimeMillis() - start) / 1000);
    }

    private static String getVeryExpensiveValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Kevin";
    }

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if (number > 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }

}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);

}
