package java8;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExample2 {

    public static void main(String[] args) {

        final List<Product> products = Arrays.asList(
                new Product(1L, "A", new BigDecimal("10.00")),
                new Product(2L, "B", new BigDecimal("20.00")),
                new Product(3L, "C", new BigDecimal("10.50")),
                new Product(4L, "D", new BigDecimal("19.00")),
                new Product(5L, "E", new BigDecimal("100.30")),
                new Product(6L, "F", new BigDecimal("109.00"))
        );

//        products.forEach(p -> p.getPrice().compareTo(new BigDecimal("20")) >= 0 );


        BigDecimal twenty = new BigDecimal("20");
        List<Product> result =
                filter(products, product -> product.getPrice().compareTo(twenty) >= 0);

        final List<Product> expensiveProducts =
                filter(products, product -> product.getPrice().compareTo(new BigDecimal(50)) > 0);

        final List<Product> discountedProducts =
                map(expensiveProducts, product -> new DiscountedProduct(
                        product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))))
                ;

        System.out.println(result);
        System.out.println(expensiveProducts);
        System.out.println(discountedProducts);

        System.out.println( "discounted product : " +
            filter(discountedProducts, product -> product.getPrice().compareTo(new BigDecimal("55")) < 0)
        );
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();

        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if(predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}

@AllArgsConstructor
@Data
class Product {
    private long id;
    private String name;
    private BigDecimal price;
}

class DiscountedProduct extends Product {

    public DiscountedProduct(long id, String name, BigDecimal price) {
        super(id, name, price);
    }
}