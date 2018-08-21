package array;

import static java.lang.Math.max;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long result = 0;
        int[] resultArray = new int[n];

        for(int i=0; i<queries.length; i++) {
            int startWith = queries[i][0] - 1;
            int endWith = queries[i][1] - 1;
            int addVal = queries[i][2];

            for(int j=0; j<n; j++){

                if(startWith <= j && endWith >= j) {
                    resultArray[j] += addVal;
                }

                result = max(result, resultArray[i]);

                System.out.print(resultArray[j] + " ");

            }
            System.out.println("result > " + result);
        }

        return result;

    }

//    static int solution(int[] A) {
//        int subSumHere = 0;
//        int maxSubSum = 0;
//
//        for (int a : A) {
//            subSumHere = max(subSumHere + a, a);
//            maxSubSum = max(maxSubSum, subSumHere);
//        }
//
//        return maxSubSum;
//    }

    public static void main(String[] args) {
        ArrayManipulation am = new ArrayManipulation();
        int[][] inputData = {{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};
                long result = am.arrayManipulation(10, inputData);

//        int[] inputData = {1,2,3};
//        int result = solution(inputData);
        System.out.println("result > " + result);
    }
}
