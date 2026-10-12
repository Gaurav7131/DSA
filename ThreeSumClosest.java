import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Array sort करा (Line them up)
        Arrays.sort(nums);

        // Diary मध्ये starting ची closest sum लिहून ठेवा (First 3 numbers)
        int closestSum = nums[0] + nums[1] + nums[2];

        // Step 2 to 5: Anchor & Helpers
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Left Helper
            int right = nums.length - 1; // Right Helper

            while (left < right) {
                // Anchor + Left Helper + Right Helper
                int currentSum = nums[i] + nums[left] + nums[right];

                // जर नवीन sum Target च्या जास्त जवळ असेल, तर diary update करा!
                // (Math.abs हे distance/फरक check करण्यासाठी वापरलं जातं)
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // The Squeeze logic
                if (currentSum < target) {
                    left++; // Sum लहान आहे, मोठी sum शोधण्यासाठी right ला जा
                } else if (currentSum > target) {
                    right--; // Sum मोठी आहे, लहान sum शोधण्यासाठी left ला जा
                } else {
                    // Jackpot! Exact target match झालं.
                    return currentSum;
                }
            }
        }

        // Loop संपल्यावर diary मधली closestSum return करा
        return closestSum;
    }
}