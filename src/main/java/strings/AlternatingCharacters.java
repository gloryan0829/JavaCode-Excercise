package strings;

public class AlternatingCharacters {

    private static int alternatingCharacters(String s) {

        if (s == null) return 0;

        int result = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            if( s.charAt(i) - s.charAt(i+1) == 0 ) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String str = "ABBABBAA";

        int result = AlternatingCharacters.alternatingCharacters(str);

        System.out.println("result > " + result);

    }
}
