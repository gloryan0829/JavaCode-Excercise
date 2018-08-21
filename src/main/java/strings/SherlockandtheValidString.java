package strings;

public class SherlockandtheValidString {

    private static String isValid(String s) {

        String print = "NO";

        int[] charCount = new int[26];

        // count
        for ( int i = 0; i < s.length(); i++ ) {
            int posIdx =  s.charAt(i) - 'a';
            charCount[posIdx]++;
        }

        int count = 0;

        for ( int i = 0; i < 25; i++ ) {
            if(charCount[i] != charCount[i+1] && charCount[i+1] != 0) {
                int temp = Math.abs(charCount[i] - charCount[i + 1]);
                if (temp != 0) {
                    count += Math.abs(charCount[i] - charCount[i + 1]);
                    charCount[i + 1]--;
                }
            }
        }

        if(count < 2) print = "YES";

        return print;
    }

    public static void main(String[] args) {
        String s = "abcdefghhgfedecba";

        String printContents = SherlockandtheValidString.isValid(s);

        System.out.println("print >> " + printContents);

    }
}
