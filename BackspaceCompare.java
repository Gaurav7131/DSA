public class BackspaceCompare {

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            // 1. Find next surviving character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break; // Valid character found
                }
            }

            // 2. Find next surviving character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break; // Valid character found
                }
            }

            // 3. Compare valid surviving characters
            if (i >= 0 && j >= 0) {
                // s.charAt(i) with t.charAt(j)
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                // One string has characters remaining while the other is exhausted
                return false;
            }

            // Move pointers left to examine the next characters
            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab#c", t1 = "ad#c";
        System.out.println("Output 1: " + backspaceCompare(s1, t1)); // true

        String s2 = "a#c", t2 = "b";
        System.out.println("Output 2: " + backspaceCompare(s2, t2)); // false
    }
}