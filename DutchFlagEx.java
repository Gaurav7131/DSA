
//Problem statement:We have to sort the colors in orders:1-red,2-white,3-blue
import java.util.Arrays;

public class DutchFlagEx {

    public static void SortColors(int[] nums) {
        // Dutch Flag Algo
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                // red color belongs to front:0
                swap(nums, low, mid);
                low++;
                mid++;

            } else if (nums[mid] == 1) {
                // white color longs to Middle:1
                mid++;
            } else {// nums[high]==2;
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // helper method to swap element in place
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        System.out.println("Original 1:" + Arrays.toString(nums1));
        SortColors(nums1);
        System.out.println("Sorted:" + Arrays.toString(nums1));
        System.out.println();

        int[] num2 = { 2, 0, 1 };
        System.out.println("Original 2:" + Arrays.toString(num2));
        SortColors(num2);
        System.out.println("Sorted:" + Arrays.toString(num2));

    }
}
