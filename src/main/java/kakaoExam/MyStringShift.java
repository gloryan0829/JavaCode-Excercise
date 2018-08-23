package kakaoExam;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class MyStringShift {



    private static String getShiftedString(String inputStr, int leftShift, int rightShift) {
        int actualLeftShift = leftShift % inputStr.length();
        int actualRightShift = rightShift % inputStr.length();

        List<Character> original = inputStr.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> leftShifted = reverse(original, actualLeftShift);
        List<Character> rightShifted = reverse(leftShifted, inputStr.length() - actualRightShift);

        return rightShifted.stream().map(Object::toString).collect(joining());
    }

    private static List<Character> reverse(List<Character> characters, int shift) {
        List<Character> left = characters.subList(0, shift);
        List<Character> right = characters.subList(shift, characters.size());

        Collections.reverse(left);
        Collections.reverse(right);

        left.addAll(right);
        Collections.reverse(left);

        return left;
    }

    public static void main(String[] args) {

        String result = MyStringShift.getShiftedString("abcd", 0, 1);
        System.out.println(result);
    }

}
