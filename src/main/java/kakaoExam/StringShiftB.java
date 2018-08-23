package kakaoExam;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class StringShiftB {

    public static String run(String input, int leftShift, int rightShift) {
        final List<Character> original = input.chars().mapToObj(e -> (char) e).collect(toList());
        final List<Character> leftShifted = reverse(original, leftShift);
        final List<Character> rightShifted = reverse(leftShifted, rightShift);
        return rightShifted.stream().map(Object::toString).collect(joining());
    }

    private static List<Character> reverse(List<Character> characters, int shift) {
        int actualShift = shift % characters.size();

        final List<Character> left = characters.subList(0, actualShift);
        final List<Character> right = characters.subList(actualShift, characters.size());
        Collections.reverse(left);
        Collections.reverse(right);

        left.addAll(right);
        Collections.reverse(left);
        return left;
    }
}