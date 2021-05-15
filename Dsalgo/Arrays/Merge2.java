public class Merge2 {

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4 };
        int[] b = { 5, 6, 7, 8 };

        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {

            if (a[i] <= b[j]) {
                c[k++] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                c[k++] = b[j];
                j++;
            }
        }

        while (i < a.length) {
            c[k++] = a[i];
            i++;
        }
        while (j < b.length) {
            c[k++] = b[j];
            j++;
        }

        for (int u = 0; u < c.length; u++) {
            System.out.print(c[u] + " ");
        }

    }

}
