import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EIDRAW {
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

    public static void main(String[] args) {
        InputReader in = new InputReader();
        String input = in.next();
        if (input == null) return;
        int h = Integer.parseInt(input);
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < h; i++) {
            // Build one V pattern
            StringBuilder v = new StringBuilder();
            
            // Left padding
            for (int j = 0; j < i; j++) v.append(' ');
            
            v.append('\\');
            
            // Inner gap
            int gap = 2 * (h - 1 - i);
            for (int j = 0; j < gap; j++) v.append(' ');
            
            v.append('/');
            
            // Right padding (to make rectangular)
            for (int j = 0; j < i; j++) v.append(' ');
            
            // Append V twice for W
            sb.append(v).append(v).append('\n');
        }
        System.out.print(sb);
    }
}
// Câu trả lời bổ sung:
// Với giới hạn 1 giây, máy tính thông thường xử lý được khoảng 10^8 phép tính. 
// Thuật toán này có độ phức tạp O(h^2) (do phải in h dòng, mỗi dòng 4h ký tự). 
// Vì vậy, h tối đa khoảng 3,000 đến 5,000 để tổng số ký tự (4h^2) không vượt quá khả năng I/O và tính toán.