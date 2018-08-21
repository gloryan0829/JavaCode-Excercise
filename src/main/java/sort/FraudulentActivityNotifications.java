package sort;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class FraudulentActivityNotifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        float median = 0;
        int notiCount = 0;

        for(int i = d; i < expenditure.length; i++ ){

            int[] previousData = Arrays.copyOfRange(expenditure,i-d, i);
            Arrays.sort(previousData, 0, previousData.length);

            // odd
            if(previousData.length % 2 == 1) {
                median = previousData[previousData.length / 2];
            }
            // even
            else {
                median = (float)( previousData[previousData.length / 2 - 1] + previousData[(previousData.length / 2)] ) / 2;
            }

            System.out.print("median : " + median + " / value : " + expenditure[i] + "\n");

            if(expenditure[i] >= (median * 2)) notiCount++;

            System.out.println("notiCount : " + notiCount);

        }

        return notiCount;

    }

    public static void main(String[] args) throws IOException {

        int[] expenditure = {2,3,4,2,3,6,8,4,5};
        int d = 5;

        int result = activityNotifications(expenditure, d);

        System.out.println("result > " + result);
    }
}

