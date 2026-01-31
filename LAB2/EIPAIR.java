import java.io.*;
import java.util.*;

class EIPAIR {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        // Đọc số lượng testcase
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            long ans = 0;
            long count = 1; // Đếm số lượng phần tử giống nhau liên tiếp

            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i - 1]) {
                    count++;
                } else {
                    if (count >= 2) {
                        ans += count * (count - 1) / 2;
                    }
                    count = 1;
                }

                // Xử lý nhóm cuối cùng ngay trong vòng lặp (gọn hơn)
                if (i == n - 1 && count >= 2) {
                    ans += count * (count - 1) / 2;
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    // Class hỗ trợ đọc dữ liệu nhanh hơn Scanner
    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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
    }
}