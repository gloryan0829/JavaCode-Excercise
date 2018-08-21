package sort;

public class bubble {

    static void CountSwaps(int[] a) {
        for(int i = 0; i < a.length; i++ ) {
            for (int j = 0; j < a.length -1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int i : a) System.out.print(i);
    }

    public static void main(String[] args) {
        bubble b = new bubble();
        int[] a = {4, 3,2,1};
        b.CountSwaps(a);
    }
}
