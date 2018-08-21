package kakao;

import java.util.Scanner;

public class question1 {

    static String[] solution(int n, int[] arr1, int[] arr2) {

        for ( int i = 0; i < 5; i++ ) {
            int arr = arr1[i] | arr2[i];
            System.out.println(Integer.toBinaryString(arr));
        }

        System.out.println("");

        for ( int i = 0; i < 5; i++ ) {
            int arr = arr1[i] | arr2[i];
            System.out.println(Integer.toBinaryString(arr));
        }

        return null;
    }

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] result = new String[n];

        result = question1.solution(n, arr1, arr2);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Dart Score : ");
        String inputVal = scanner.nextLine();

        int len = inputVal.length();
        int step = 1;
        int lenPos = 0;
        int[] score = new int[3];
        int scorePos = 0;

        while(lenPos < len) {
            String target = inputVal.substring(lenPos,lenPos+1);
            if(step == 1) {
                try {
                    // 1단계 점수 처리
                    score[scorePos] = Integer.parseInt(target);
                    step++;

                } catch (Exception e) {
                    // 3단계 옵션 처리
                    if("*".equals(target)) {

                    } else if("#".equals(target)) {

                    } else {
                        System.out.println("유효한 다트 점수가 아닙니다");
                        return;
                    }
                }
            } else if (step == 2) {
                // 1.2 2단계 입력처리
                if("S".equals(target)) {
                    score[scorePos] = (int)Math.pow(score[scorePos], 1);
                } else if ("D".equals(target)) {
                    score[scorePos] = (int)Math.pow(score[scorePos], 2);
                } else if ("T".equals(target)) {
                    score[scorePos] = (int)Math.pow(score[scorePos], 3);
                }  else if ("0".equals(target)) {
                    if(score[scorePos] == 1) {
                        score[scorePos] = 10;
                        scorePos--;
                        step++;
                    }
                } else {
                    System.out.println("유효한 다트 점수가 아닙니다");
                    return;
                }
                scorePos++;
                step--;
            }
            lenPos++;
        }

        System.out.println(score[0] + score[1] + score[2]);
    }


}
