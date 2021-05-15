public class Sort012 {

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void threeway(int[] a, int end) {
        int start = 0;
        int mid = 0;
        int pivot = 1;
        while (mid <= end) {
            if (a[mid] < pivot) {
                swap(a, start, mid);
                ++mid;
                ++start;
            } else if (a[mid] > pivot) {
                swap(a, mid, end);
                end--;
            } else {
                ++mid;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 0, 2, 1, 2, 0, 2 };
        int end = a.length - 1;
        threeway(a, end);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

    }

}
