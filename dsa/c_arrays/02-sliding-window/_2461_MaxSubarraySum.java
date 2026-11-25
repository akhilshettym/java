import java.util.*;

public class _2461_MaxSubarraySum {

    public static long maximumSubarrySum(int[] nums, int k) {
        int left = 0;
        long max_sum = 0;
        long window_sum = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                window_sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            window_sum += nums[right];

            if (right - left + 1 == k) {
                max_sum = Math.max(max_sum, window_sum);

                set.remove(nums[left]);
                window_sum -= nums[left];
                left++;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };

        long result = maximumSubarrySum(nums, k);
        System.out.println(result);
    }
}
