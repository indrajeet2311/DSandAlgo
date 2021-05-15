import java.util.*;

//Easier takeaway:

//2 pointers, start = end = 0
//hashmap<Char, Integer> to store all occurances of target substring
//counter variable to indicate current [start, end] window validity
//while valid, find the possible answer
//while target.length = end - start, add start to result

public class MinWindow {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        // System.out.println(counter);

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // System.out.println(map);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;
            // System.out.println(counter);
            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    System.out.println(map);
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }

                System.out.println("begin" + " " + begin);
                System.out.println("end" + " " + end);
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if (len == Integer.MAX_VALUE)
            return "";
        return s.substring(head, head + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinWindow main = new MinWindow();
        System.out.println(minWindow(s, t));
    }
}
