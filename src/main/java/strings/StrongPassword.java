package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrongPassword {


    private static int minimumNumber(int n, String password) {

        List<Integer> minimumQualification = new ArrayList<>();


        int exclusiveCount = 0;
        final String numbers = "0123456789";
        final String lower_case = "abcdefghijklmnopqrstuvwxyz";
        final String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String special_characters = "!@#$%^&*()-+";

        if(password.length() < 6) {
            minimumQualification.add(6 - password.length());
        }

        // numberCheck
        for(int i = 0; i < numbers.length(); i++){
            if(password.contains(String.valueOf( numbers.charAt(i) ))) {
                exclusiveCount++;
            }
        }
        minimumQualification.add(exclusiveCount);

        // lowercaseCheck
        exclusiveCount = 0;
        for(int i = 0; i < lower_case.length(); i++){
            if(password.contains(String.valueOf( lower_case.charAt(i) ))) {
                exclusiveCount++;
            }
        }
        minimumQualification.add(exclusiveCount);

        // uppercaseeCheck
        exclusiveCount = 0;
        for(int i = 0; i < upper_case.length(); i++){
            if(password.contains(String.valueOf( upper_case.charAt(i) ))) {
                exclusiveCount++;
            }
        }
        minimumQualification.add(exclusiveCount);

        // special_characters
        exclusiveCount = 0;
        for(int i = 0; i < special_characters.length(); i++){
            if(password.contains(String.valueOf( special_characters.charAt(i) ))) {
                exclusiveCount++;
            }
        }
        minimumQualification.add(exclusiveCount);

        return minimumQualification.stream().mapToInt(i -> i).max().getAsInt();

    }

    public static void main(String[] args) {
        int str = StrongPassword.minimumNumber("Ab1".length(), "Ab1");
        System.out.println("value > " + str);
    }
}
