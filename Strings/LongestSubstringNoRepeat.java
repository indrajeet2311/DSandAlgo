import java.util.*;

//Easier takeaway:

//2 pointers, start = end = 0
//hashmap<Char, Integer> to store all occurances of target substring
//counter variable to indicate current [start, end] window validity
//while valid, find the possible answer
//while target.length = end - start, add start to result

public class LongestSubstringNoRepeat {

    public static int lengthofLongest(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0, counter = 0, d = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1)
                counter++;
            end++;

            while (counter > 0) {
                char tempc = s.charAt(begin);
                if (map.get(tempc) > 1)
                    counter--;
                map.put(tempc, map.get(tempc) - 1);
                begin++;
            }

            d = Math.max(d, end - begin);

        }

        return d;
    }

    public static void main(String[] args) {
        String s = "abcdaberty";
        System.out.println(lengthofLongest(s));

    }
}
