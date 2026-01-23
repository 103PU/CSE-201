
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EIUGIFT1 {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {

        int m = sc.nextInt();
        int n = sc.nextInt();

        long[] gift = new long[m];
        long[] paper = new long[n];

        for (int i = 0; i < gift.length; i++) {
            gift[i] = sc.nextInt();
        }

        for (int i = 0; i < paper.length; i++) {
            paper[i] = sc.nextInt();
        }

        Arrays.sort(gift);
        Arrays.sort(paper);

        int i = 0;
        int j = 0;

        int count = 0;

        // two pointer
        while (i < gift.length && j < paper.length) {
            long min = gift[i] * 2;
            long max = gift[i] * 3;

            if (paper[j] < min) {
                j++;
            } else if (paper[j] > max) {
                i++;
            } else {
                count++;
                i++;
                j++;
            }

        }
        System.out.println(count);
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
