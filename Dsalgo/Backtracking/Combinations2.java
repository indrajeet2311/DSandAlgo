import java.util.*;

public class Combinations2 {

    static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {

        if (remain < 0)
            return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 5, 4, 8, 7 };
        int target = 10;

        System.out.println(combinationSum(nums, target));

    }

}
