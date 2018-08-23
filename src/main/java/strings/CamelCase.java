package strings;

import java.util.ArrayList;
import java.util.List;

public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {

        char[] chars = s.toCharArray();

        String temp = "";
        List<String> words = new ArrayList<>();

        for( int i = 0; i < chars.length; i++ ) {

            if(Character.isLowerCase(chars[i])) {
                temp += chars[i];
            } else if ( Character.isUpperCase(chars[i]) ) {
                words.add(temp);
                temp = String.valueOf( chars[i] );
            }

            if ( chars.length == (i + 1) ) {
                words.add(temp);
            }

        }

        return words.size();

    }

    public static void main(String[] args) {

        int result = CamelCase.camelcase("saveChangesInTheEditor");

        System.out.println("result > " + result);
    }
}
