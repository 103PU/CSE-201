import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EIUPREIU {
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
        int n = in.nextInt();
        
        StringBuilder sb = new StringBuilder();
        int eWidth = n / 2 + 1;
        int uWidth = n / 2 + 2;
        
        for (int i = 0; i <= n; i++) {
            // Build E
            if (i == 0) {
                sb.append(' ');
                for (int j = 0; j < eWidth - 1; j++) sb.append('_');
            } else if (i == n / 2 || i == n) {
                sb.append('|');
                for (int j = 0; j < eWidth - 1; j++) sb.append('_');
            } else {
                sb.append('|');
                for (int j = 0; j < eWidth - 1; j++) sb.append(' ');
            }
            
            sb.append(' '); // Separator
            
            // Build I
            if (i == 0) {
                sb.append(' ');
            } else {
                sb.append('|');
            }
            
            sb.append(' '); // Separator
            
            // Build U
            if (i == 0) {
                for (int j = 0; j < uWidth; j++) sb.append(' ');
            } else if (i == n) {
                sb.append('|');
                for (int j = 0; j < uWidth - 2; j++) sb.append('_');
                sb.append('|');
            } else {
                sb.append('|');
                for (int j = 0; j < uWidth - 2; j++) sb.append(' ');
                sb.append('|');
            }
            
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
