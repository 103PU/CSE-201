import java.io.*;
import java.util.*;

public class EIFLPEASY1 {

    public static void main(String[] args) {
        InputReader in = new InputReader();

        // Read the number of test cases
        // Using "next()" then "parseInt" to handle potential whitespace issues safely
        String testCaseStr = in.next();
        if (testCaseStr == null)
            return;
        int testCaseCount = Integer.parseInt(testCaseStr);

        StringBuilder sb = new StringBuilder();

        while (testCaseCount-- > 0) {
            long number = in.nextLong();

            if (checkHappyNumber(number)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }

    // Function to check if a number is "Happy"
    // Uses Floyd's Cycle Detection (Tortoise and Hare algorithm)
    private static boolean checkHappyNumber(long number) {
        long slowSum = number;
        long fastSum = number;

        do {
            // Slow pointer moves 1 step (calculates sum once)
            slowSum = calSumSquaredDigits(slowSum);

            // Fast pointer moves 2 steps (calculates sum twice)
            fastSum = calSumSquaredDigits(calSumSquaredDigits(fastSum));

        } while (slowSum != fastSum); // Loop until they meet

        // If they meet at 1, it's a happy number.
        // If they meet at any other number, it's a cycle (infinite loop).
        return slowSum == 1;
    }

    // Function to calculate the sum of squares of digits
    // Logic: 19 -> 1^2 + 9^2 = 82
    private static long calSumSquaredDigits(long n) {
        long sum = 0;
        while (n > 0) {
            long digit = n % 10; // Extract last digit
            sum += digit * digit; // Square it and add to sum
            n /= 10; // Remove last digit
        }
        return sum;
    }

    // Helper class for fast input reading
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null)
                        return null;
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}