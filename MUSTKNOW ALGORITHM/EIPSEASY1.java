
import java.util.*;

class EIPSEASY1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        // Mảng đánh dấu vị trí xuất hiện đầu tiên của số dư
        int[] map = new int[k];

        // Khởi tạo giá trị mặc định là -2 (chưa thấy bao giờ)
        Arrays.fill(map, -2);

        // Quan trọng: Số dư 0 coi như xuất hiện tại vị trí -1
        // (tưởng tượng có tổng = 0 ngay trước phần tử đầu tiên)
        map[0] = -1;

        long currentSum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            // Tính số dư
            int rem = (int) (currentSum % k);

            // Xử lý số dư âm trong Java (VD: -5 % 3 = -2 -> cần chuyển thành 1)
            if (rem < 0) {
                rem += k;
            }

            if (map[rem] != -2) {
                // Nếu đã gặp số dư này trước đó tại vị trí map[rem]
                // Thì đoạn từ map[rem] + 1 đến i có tổng chia hết cho K
                int len = i - map[rem];
                if (len > maxLen) {
                    maxLen = len;
                }
            } else {
                // Nếu đây là lần đầu tiên gặp số dư này, lưu lại vị trí
                map[rem] = i;
            }
        }

        System.out.println(maxLen);
    }
}