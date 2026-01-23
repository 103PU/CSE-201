import java.io.*;
import java.util.*;

class EIPAIR {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        // Đọc số lượng testcase
        int t = reader.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = reader.nextInt();
            
            // Map lưu tần suất xuất hiện: Key = Giá tiền, Value = Số lượng đã gặp
            HashMap<Integer, Integer> map = new HashMap<>();
            long ans = 0; // QUAN TRỌNG: Dùng long để tránh tràn số
            
            for (int i = 0; i < n; i++) {
                int price = reader.nextInt();
                
                // Lấy số lượng quà cùng giá đã gặp trước đó
                int count = map.getOrDefault(price, 0);
                
                // Nếu trước đó đã có 'count' món quà giá 'price'
                // Thì món quà hiện tại sẽ tạo được thêm 'count' cặp với các món trước đó
                ans += count;
                
                // Cập nhật lại số lượng quà giá 'price'
                map.put(price, count + 1);
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
                    if (line == null) return null;
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