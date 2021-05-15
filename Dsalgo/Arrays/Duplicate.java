public class Duplicate {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 2 };

        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        System.out.println(slow);
    }

}
