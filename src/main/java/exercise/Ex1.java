package exercise;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Ex1 {



    public static void main(String[] args) {
//
//        int[] intArr = {1,2,3,4,5,6};
//
//        Ex1.intSum(intArr);
//
//        List<Integer> a = Arrays.asList(17, 28, 30);
//        List<Integer> b = Arrays.asList(99, 16, 8);
//        List<Integer> result = Ex1.compareTriplets(a, b);
//        result.stream().forEach(e -> System.out.print(e + " "));
//
//
//        long[] ar = {1000000001, 1000000002, 1000000003, 1000000004, 1000000005};
//        long vResult = Ex1.veryBigSum(ar);
//        System.out.println("Result >> " + vResult);
//
//
//        int[][] arr_3d = {{11, 2, 4},{4, 5, 6},{10, 8, -12}};
//
//        System.out.println(Ex1.diagonalDifference(arr_3d));
//
//        int[] inputArr = {-4, 3, -9, 0, 4, 1};
//
//        Ex1.plusMinus(inputArr);
//
//        Ex1.staircase(6);

//        int[] inputArr2 = {2, 1, 3, 5, 4};
//
//        Ex1.miniMaxSum(inputArr2);

//          int[] candleHeightArr = {4, 3, 2, 4, 4};
//
//          int result = Ex1.birdayCakeCandles(candleHeightArr);
//
//          System.out.println("blowed out candles : " + result);

        String newTime = Ex1.timeConversion("12:45:54PM");

        System.out.println("Time Conversion : " + newTime);

    }

    /*
    * Complete the timeConversion function below.
    */
    static String timeConversion(String s) {

        s = s.replaceAll(":","");
        String hour = s.substring(0, 2);
        String min = s.substring(2, 4);
        String sec = s.substring(4, 6);
        String st = s.substring( s.length()-2, s.length() );

        int tempHour = Integer.parseInt(hour);

        if("PM".equals(st)) {
            if(tempHour < 12 ) hour = String.valueOf(tempHour + 12);
        }
        else if ("AM".equals(st)) {
            if (tempHour == 12) hour = "00";
        }
        return hour + ":" + min + ":" + sec;
    }

    private static int birdayCakeCandles(int[] ar) {

        int result = 0;

        int max = IntStream.of(ar).max().getAsInt();

        Arrays.sort( ar, 0, ar.length );

        for(int i = ar.length-1; 0 <= i; i--) {

            if(max != ar[i]) break;

            result++;
        }

        return result;
    }

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long minSum = 0;
        long maxSum = 0;
        Arrays.sort( arr, 0, arr.length );

        for(int i = 0; i < arr.length; i++ ) {
            if ( i != arr.length - 1 ) maxSum += arr[i];
            if ( i != 0 ) minSum += arr[i];
        }

        System.out.println(maxSum + " " + minSum);
    }

    // Complete the staircase function below.
    static void staircase(int n) {

        for(int sharps=1,spaces=n-1; sharps <= n; sharps++,spaces--) {

            for (int i=0; i<spaces; i++) {
                System.out.print(" ");
            }

            for (int i=0; i<sharps; i++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }

    static void plusMinus(int[] arr) {

        int positiveCnt = 0;
        int negativeCnt = 0;
        int zeroCnt = 0;

        for(int temp : arr) {

            if(temp > 0)
                positiveCnt += 1;
            else if(temp == 0)
                negativeCnt += 1;
            else
                zeroCnt += 1;

        }
        System.out.println(String.format("%.6f", (double)positiveCnt / (arr.length)));
        System.out.println(String.format("%.6f", (double)zeroCnt / (arr.length)));
        System.out.println(String.format("%.6f", (double)negativeCnt / (arr.length)));

    }

    static int diagonalDifference(int[][] arr) {

        int result = 0;
        int leftToRightDiagonals = 0;
        int rightToLeftDiagonals = 0;

        for(int i = 0; i < arr.length; i++) {
            leftToRightDiagonals += arr[i][i];
            rightToLeftDiagonals += arr[arr.length-(i+1)][i];
        }

        result = Math.abs(leftToRightDiagonals - rightToLeftDiagonals);

        return result;
    }

    private static long veryBigSum(long[] ar) {
        return LongStream.of(ar).sum();
    }

    private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<>();
        int aCnt = 0;
        int bCnt = 0;

        for(int i = 0; i < a.size(); i++) {
            if( a.get(i).compareTo(b.get(i)) > 0 ) {
                aCnt++;
            } else if ( a.get(i).compareTo(b.get(i)) < 0 ) {
                bCnt++;
            }
        }

        result.add(aCnt);
        result.add(bCnt);

        return result;

    }

    private static void intSum(int[] intArr) {

        int sum = IntStream.of(intArr).sum();
        System.out.println("sum -> " + sum);


    }

}
