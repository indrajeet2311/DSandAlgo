import java.util.*;

public class Sum {

    static void Sums(int[] a, int target) {

        HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();

        for (int i = 0; i < a.length; i++) {
            int sum = a[i];
            if (x.containsKey(target - sum)) {
                System.out.println(sum + " " + (target - sum));
            } else {
                x.put(a[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        int target = 5;
        Sums(a, target);

    }
}
