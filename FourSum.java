import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // 1) Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        // 2) Anchor for num1 (i)
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate numbers for Anchor 1
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 3) Anchor for num2 (j)
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate numbers for Anchor 2
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 4) Two Pointers (left & right)
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];// Cast

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate values for left and right
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println("Num1 Output: " + fourSum(nums1, target));
        // Output: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }
}