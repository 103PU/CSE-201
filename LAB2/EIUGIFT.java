import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EIUGIFT {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {

        int products = sc.nextInt();
        long amount = sc.nextLong();

        long[] price = new long[products];

        for (int i = 0; i < price.length; i++) {
            price[i] = sc.nextLong();
        }

        Arrays.sort(price);
        // two pointer

        int x = 0;
        int y = products - 1;

        long minifference = amount;
        long maxsum = -1;
        while (x < y) {
            long total = price[x] + price[y];
            if (total <= amount) {
                long difference = price[y] - price[x];
                if (total > maxsum) {
                    maxsum = total;
                    minifference = difference;
                } else if (total == maxsum) {
                    minifference = Math.min(difference, minifference);
                }
                x++;
            } else {
                y--;
            }

        }
        if (maxsum != -1) {
            System.out.println(maxsum + " " + minifference);
        } else {
            System.out.println("-1 -1");
        }

    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
