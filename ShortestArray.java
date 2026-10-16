public class ShortestArray {

    public static int ShortestUnsortedArray(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int n = nums.length;

        // four pointers:O(1)
        int end = -1;
        int start = -1;

        int max = nums[0];
        int min = nums[n - 1];

        // 1 -loop 2-passes
        for (int i = 0; i < n; i++) {
            // left -right ; find right boundary(end)
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }

            // right - left; find left boundary(start)
            int j = n - 1 - i;
            if (nums[j] > min) {
                start = j;
            } else {
                min = nums[j];
            }
        }
        // If Array is already sorted
        if (end == -1) {
            return 0;
        }

        return end - start + 1;
    }

    public static void main(String[] args) {
        // Standard case
        int[] nums1 = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println("Test 1 Output: " + ShortestUnsortedArray(nums1)); // Expected: 5

        // Already sorted
        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println("Test 2 Output: " + ShortestUnsortedArray(nums2)); // Expected: 0

        // Single element
        int[] nums3 = { 1 };
        System.out.println("Test 3 Output: " + ShortestUnsortedArray(nums3)); // Expected: 0

        // Completely reversed
        int[] nums4 = { 5, 4, 3, 2, 1 };
        System.out.println("Test 4 Output: " + ShortestUnsortedArray(nums4)); // Expected: 5

        // Duplicates present
        int[] nums5 = { 1, 3, 2, 2, 2 };
        System.out.println("Test 5 Output: " + ShortestUnsortedArray(nums5)); // Expected: 4
    }
}
