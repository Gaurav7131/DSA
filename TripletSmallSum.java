import java.util.Arrays;

public class TripletSmallSum {
    public static int tripletsmall(int[] arr, int sum) {
        // sort the array
        Arrays.sort(arr);

        // achor +helper
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum < sum) {
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = { -2, 0, 1, 3 };
        int sum1 = 2;
        System.out.println("Sum is:" + tripletsmall(arr1, sum1));

    }

}
