package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;


public class HashTablesRansomNote {

    static void checkMagazine(String[] magazine, String[] note) {

        String result = "Yes";

        HashMap<String,Integer> magazineMap =
                (HashMap<String, Integer>) Arrays.asList(magazine)
                                                .stream()
                                                .collect(Collectors.toMap(
                                                        w -> w,
                                                        w -> 1,
                                                        Integer::sum
                                                ));

        for(String key : note) {
            if( magazineMap.containsKey(key) ) {
                if( magazineMap.get(key)-1 == 0 ) {
                    magazineMap.remove(key);
                } else {
                    magazineMap.put(key, magazineMap.get(key)-1);
                }
            } else {
                result = "No";
                break;
            }
        }

        System.out.println(result+"");

    }

    public static void main(String[] args) {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        String[] note = {"two", "times", "two", "is", "four"};

        HashTablesRansomNote.checkMagazine(magazine, note);
    }

}
