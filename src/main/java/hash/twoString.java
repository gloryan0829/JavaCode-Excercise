package hash;

import java.util.HashMap;
import java.util.Map;

public class twoString {

    static String twoStrings(String s1, String s2) {

        String result = "NO";
        Map<Character,Integer> stringMap = new HashMap<>();

        for(int i = 0; i < s1.length(); i++ ) {
             stringMap.put(s1.charAt(i),0);
        }

        for(int i = 0; i < s2.length(); i++ ) {
            if( stringMap.containsKey(s2.charAt(i)) ) {
                result = "YES";
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println( " result > " + twoString.twoStrings(s1, s2) );
    }
}
