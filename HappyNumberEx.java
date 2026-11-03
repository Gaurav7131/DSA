public class HappyNumberEx {
    // Helper fn:Sum of square of digits
    public static int getNext(int n) {
        int totalSum = 0;

        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }

    // Floy'd cycle detection strategy:slow & fast: 0(logn) time & 0(1)-aux space
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        // Move slow by 1 and fast by 2 until they collides
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;// happy no
    }

    public static void main(String[] args) {
        int n1 = 19;
        System.out.println("Input: " + n1 + " -> Is Happy: " + isHappy(n1));

        // Test Case 2: n = 2 -> Expected: false (loops into 4 -> 16 -> 37 -> 58 -> 89
        // -> 145 -> 42 -> 20 -> 4)
        int n2 = 2;
        System.out.println("Input: " + n2 + " -> Is Happy: " + isHappy(n2));

        // n = 7 -> Expected: true
        int n3 = 7;
        System.out.println("Input: " + n3 + " -> Is Happy: " + isHappy(n3));

        // Test Case 4: n = 1 -> Expected: true
        int n4 = 1;
        System.out.println("Input: " + n4 + " -> Is Happy: " + isHappy(n4));
    }
}
