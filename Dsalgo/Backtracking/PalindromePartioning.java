import java.util.*;

public class PalindromePartioning {

    static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length())
            list.add(new ArrayList<>(tempList));
        else {

            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    static boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
