import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class _001_TwoSum {

    public static void bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];

                if (sum == target) {
                    System.out.println("Brute Force: [" + i + ", " + j + "]");
                    return;
                }
            }
        }
    }

    public static int[] hashMapApproach(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];

            if (map.containsKey(comp)) {
                return new int[] { map.get(comp), i };
            }

            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        // int[] nums = { 3, 2, 4 };
        int target = 17;

        bruteForce(nums, target);

        int[] result = hashMapApproach(nums, target);
        System.out.println("HashMap Result: " + Arrays.toString(result));
    }
}