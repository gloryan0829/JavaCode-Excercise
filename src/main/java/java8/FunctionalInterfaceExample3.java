package java8;

import java.math.BigDecimal;

/**
 * my functional interface..
 */
public class FunctionalInterfaceExample3 {

    public static void main(String[] args) {

        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();

        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal(100.00)));

        final InvalidFunctionalBigDecimalToCurrency a = new InvalidFunctionalBigDecimalToCurrency() {
            @Override
            public <T> toString(final T value) {
                return value;
            }
        };
    }

}


@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

@FunctionalInterface
interface InvalidFunctionalBigDecimalToCurrency {
    <T> toCurrency(T value);
}