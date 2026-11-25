public class _011_MostWater {

    public static int MostWater(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;

            int area = h * w;

            maxarea = Math.max(maxarea, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int result = MostWater(height);
        System.out.println("Most Water: " + result);
    }
}