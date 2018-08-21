package strings;

import java.util.stream.IntStream;

public class Anagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        int count1[] = new int[26];
        int count2[] = new int[26];


        for (int i = 0; i < a.length(); i++) {
            count1[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++)
            count2[b.charAt(i) - 'a']++;

        int result = 0;
        for (int i = 0; i < 26; i++)
            result += Math.abs(count1[i] - count2[i]);

        return result;
    }


    public static void main(String[] args) {
        String a = "cdee";
        String b = "hea";

        int result = Anagram.makeAnagram(a, b);
        System.out.println("deletion cnt : " + result);
    }
}
