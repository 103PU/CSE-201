import java.io.*;
import java.util.*;

class EIUPAGES {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();

        String line = in.next();
        if (line == null)
            return;
        int n = Integer.parseInt(line);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);

        int i = 0;
        while (i < n) {
            // Logic tìm chuỗi liên tiếp: GIỐNG HỆT LAB1
            int j = i;
            while (j + 1 < n && arr[j + 1] == arr[j] + 1) {
                j++;
            }

            int length = j - i + 1;

            // Logic in: GIỐNG HỆT LAB1 (Luôn có dấu cách ở cuối)
            if (length >= 3) {
                sb.append(arr[i]).append("-").append(arr[j]).append(" ");
            } else if (length == 2) {
                sb.append(arr[i]).append(" ").append(arr[j]).append(" ");
            } else {
                sb.append(arr[i]).append(" ");
            }

            i = j + 1;
        }

        System.out.println(sb);
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

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
