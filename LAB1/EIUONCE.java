
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class EIUONCE {
	public static void main(String[] args) {
		InputReader sc = new InputReader(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Map<Integer, Integer> countMap = new HashMap<>();

			// Đếm số lần xuất hiện của mỗi phần tử
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				countMap.put(num, countMap.getOrDefault(num, 0) + 1);
			}

			// Lấy các phần tử chỉ xuất hiện 1 lần và sắp xếp
			Set<Integer> resultSet = new TreeSet<>();
			for (int num : countMap.keySet()) {
				if (countMap.get(num) == 1) {
					resultSet.add(num);
				}
			}

			// In kết quả
			boolean first = true;
			for (int num : resultSet) {
				if (!first)
					System.out.print(" ");
				System.out.print(num);
				first = false;
			}
			System.out.println();
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