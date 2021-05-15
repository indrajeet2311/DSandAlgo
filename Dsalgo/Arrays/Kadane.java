public class Kadane {

    public static void main(String[] args) {

        int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };

        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        System.out.println(maxSum);
    }

}
