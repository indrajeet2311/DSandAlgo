import java.util.*;

public class ThreeSum {

    public static void Sums(int[] a, int target) {

        Arrays.sort(a);
        for (int i = 0; i < a.length - 2; i++) {
            if (i == 0 || a[i] > a[i - 1]) {
                int j = i + 1;
                int k = a.length - 1;
                while (j < k) {
                    if (a[i] + a[j] + a[k] == target) {
                        System.out.print(a[i] + " " + a[j] + " " + a[k]);
                        j++;
                        k--;

                        while (j < k && a[k - 1] == a[k])
                            k--;
                        while (j < k && a[j + 1] == a[j])
                            j++;
                    } else if (a[i] + a[j] + a[k] > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int target = 6;
        Sums(a, target);
    }
}
