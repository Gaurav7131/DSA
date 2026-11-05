public class findDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        // 1)Cycle detection using floyd's cycle detection strategy
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];// 1 step
            fast = nums[nums[fast]];// 2 steps
        } while (slow != fast);

        // 2:Entrance of the cycle (duplicate no)
        int ptr1 = nums[0];
        int ptr2 = slow;

        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];// 1 step
            ptr2 = nums[ptr2];// 1 step
        }

        return ptr1;// duplicate no
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 2, 4, 5 };
        System.out.println("Result:" + findDuplicate(nums1));// 2

        int[] nums2 = { 2, 3, 4, 5, 4 };
        System.out.println("Result2:" + findDuplicate(nums2));// 4

    }
}
