public class StockSell {

    public static void main(String[] args) {
        int[] a = { 7, 1, 5, 3, 6, 4 };
        int min = Integer.MAX_VALUE;
        int maxPro = 0;

        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);
            maxPro = Math.max(maxPro, a[i] - min);
        }

        System.out.println(maxPro);

    }
}
