public class ReverseString {

    public static void swap(char[] x, int i, int j) {
        char temp = x[i];
        x[i] = x[j];
        x[j] = temp;

    }

    static void ReverseStrings(String s) {
        int low = 0;
        int high = s.length() - 1;
        char[] x = s.toCharArray();
        for (int i = low, j = high; i < j; i++, j--) {
            swap(x, i, j);
        }
        String str = String.valueOf(x);
        System.out.println(str);
    }

    public static void main(String[] args) {
        String s = "Indrajeet";
        ReverseStrings(s);

    }

}
