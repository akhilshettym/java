import java.util.Arrays;

// DNS - Dutch National Flag Algorithm

public class _075_SortColors {

    public static int[] sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };

        int[] result = sortColors(nums);
        System.out.println("Sort Colors: " + Arrays.toString(result));
    }
}