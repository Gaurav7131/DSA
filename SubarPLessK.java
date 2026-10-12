class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Edge case If k is 0 or -ve, we can never find a product strictly < k if
        // unfortunately finds then return 0 end!
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;// multiply with 1 always a no but multiply with 0 to avoid this conflict
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];//// Multiply the new number into our current product

            // If Product is too big then Shrink
            while (product >= k) {
                product /= nums[left]; // Divide out the left number
                left++;
            }
            // Add all valid subarrays ending at the current 'right' pointer
            count += (right - left + 1);
        }
        // final no=Scorecard
        return count;

    }
}