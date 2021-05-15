import java.util.*;

public class RotateArray {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void reverse(int[] a, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            swap(a, i, j);
        }
    }

    static void RotateArrays(int[] a, int k, int n) {

        // Reverse the last n-k
        reverse(a, n - k, n - 1);
        // Reverse the first upto n-k
        reverse(a, 0, n - k - 1);
        // Reverse the whole array
        reverse(a, 0, n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        int k = 2;
        RotateArrays(a, k, n);

        System.out.println("The values inside the Rotated Array are");

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
