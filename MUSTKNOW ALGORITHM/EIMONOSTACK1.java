import java.util.*;

class EIMONOSTACK1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // 1. Đọc input
        if (!sc.hasNextInt())
            return;
        int m = sc.nextInt(); // Số phần tử mảng A
        int n = sc.nextInt(); // Số phần tử mảng B

        int[] A = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }

        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        // 2. Xử lý logic tìm Next Greater Element trên mảng B
        // Map lưu kết quả: Key = Giá trị phần tử, Value = Next Greater của nó
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int x : B) {
            // Khi gặp số x lớn hơn đỉnh stack -> x chính là "người lớn hơn" mà đỉnh stack
            // đang chờ
            while (!stack.isEmpty() && stack.peek() < x) {
                int val = stack.pop();
                nextGreaterMap.put(val, x);
            }
            // Đẩy x vào stack để chờ tìm người lớn hơn nó trong tương lai
            stack.push(x);
        }

        // 3. In kết quả theo thứ tự mảng A
        StringBuilder sb = new StringBuilder();
        for (int x : A) {
            // Lấy kết quả từ Map, nếu không có (số đó vẫn nằm trong stack) thì trả về -1
            sb.append(nextGreaterMap.getOrDefault(x, -1)).append(" ");
        }

        System.out.print(sb);
    }
}
