package kakaoExam;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StringShift {

    //abcd

    public static String getShiftedString(String s, int leftShift, int rightShift) {
        int actualLeftShift = leftShift % s.length();
        int actualRightShift = rightShift % s.length();

        final List<Character> original = s.chars().mapToObj(e -> (char) e).collect(toList());
        System.out.println("original > " + original.toString());
        final List<Character> leftShifted = reverse(original, actualLeftShift);
        System.out.println("leftShifted > " + leftShifted.toString());
        final List<Character> rightShifted = reverse(leftShifted, s.length() - actualRightShift);
//        System.out.println("rightShifted > " + rightShifted.toString());

        return rightShifted.stream().map(Object::toString).collect(joining());
    }

    private static List<Character> reverse(List<Character> characters, int shift) {
        final List<Character> left = characters.subList(0, shift);
        System.out.println("left " + shift + " > " + left.toString());
        final List<Character> right = characters.subList(shift, characters.size());
        System.out.println("right " + characters.size() + " > " + right.toString());
        Collections.reverse(left);
        Collections.reverse(right);

        left.addAll(right);
        Collections.reverse(left);

        return left;
    }

    public static void main(String[] args) {
        String result = StringShift.getShiftedString("abcd", 2,1);
        System.out.println(result);
    }
}