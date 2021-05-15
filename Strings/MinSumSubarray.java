public class MinSumSubarray {

    static void findSubarray(int[] a, int k) {

        int window_sum = 0;
        int min_window = Integer.MAX_VALUE;
        int last = 0;

        for (int i = 0; i < a.length; i++) {
            window_sum += a[i];

            if (i + 1 >= k) {
                if (min_window > window_sum) {
                    min_window = window_sum;
                    last = i;
                }

                window_sum -= a[i + 1 - k];
            }
        }

        System.out.printf("The minimum sum subarray is (%d, %d)", last - k + 1, last);
    }

    public static void main(String[] args) {

        int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
        int k = 3;

        findSubarray(arr, k);

    }
}
