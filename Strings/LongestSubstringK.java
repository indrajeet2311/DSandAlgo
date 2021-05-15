import java.util.*;

//Easier takeaway:

//2 pointers, start = end = 0
//hashmap<Char, Integer> to store all occurances of target substring
//counter variable to indicate current [start, end] window validity
//while valid, find the possible answer
//while target.length = end - start, add start to result

public class LongestSubstringK {

    static final int MAX_CHAR = 128;

    public static String findLongest(String str, int k) {

        int end = 0, begin = 0;

        Set<Character> window = new HashSet<>();
        int[] freq = new int[MAX_CHAR];

        for (int low = 0, high = 0; high < str.length(); high++) {

            window.add(str.charAt(high));
            freq[str.charAt(high)]++;

            while (window.size() > k) {
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }

                low++;
            }

            if (end - begin < high - low) {
                end = high;
                begin = low;
            }
        }

        return str.substring(begin, end + 1);

    }

    public static void main(String[] args) {

        String str = "abcbdbdbbdcdabd";
        int k = 2;

        System.out.println(findLongest(str, k));

    }
}
