
public class RepeatnMissing {

    public static void printTwo(int[] a, int n) {

        System.out.println("The Repeating Number");
        for (int i = 0; i < n; i++) {
            int x = Math.abs(a[i]);
            if (a[x - 1] > 0)
                a[x - 1] = -a[x - 1];
            else
                System.out.println(x);
        }

        System.out.println("The Missing Number");
        for (int i = 0; i < n; i++) {
            if (a[i] > 0)
                System.out.println(i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 4, 5, 4 };
        int n = a.length;
        printTwo(a, n);

    }

}
