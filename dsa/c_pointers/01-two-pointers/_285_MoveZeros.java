import java.util.Arrays;

public class _285_MoveZeros {

    public static int[] MoveZeros(int[] nums) {

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };

        int[] result = MoveZeros(nums);
        System.out.println("Move Zeros: " + Arrays.toString(result));
    }
}