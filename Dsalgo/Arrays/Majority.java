public class Majority {

    public static void main(String[] args) {
        // for n/2 elements
        int[] nums = { 1, 2, 3, 1, 2, 6, 2 };
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            else if (num == candidate)
                count++;
            else
                count--;
        }

        System.out.println(candidate);

    }
}
