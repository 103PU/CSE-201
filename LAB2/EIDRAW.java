
import java.util.*;

class EIDRAW {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int n = sc.nextInt();
        String result = "";
        for (int i = 0; i < n; i++) {
            result += drawLine(n, i);
            if (i < n - 1) {
                result += "\n";
            }
        }
        System.out.println(result);
    }

    static String drawLine(int n, int row) {
        String line = "";
        line += (drawLeft(n, row) + drawRight(n, row)).repeat(2);
        return line;
    }

    static String drawLeft(int n, int row) { // draw "\"
        String line = "";
        line += " ".repeat(row) + "\\" + " ".repeat((n - row - 1));
        return line;
    }

    static String drawRight(int n, int row) { // draw "/"
        String line = "";
        line += " ".repeat((n - row - 1)) + "/" + " ".repeat(row);
        return line;
    }
}
// Câu trả lời bổ sung:
// Với giới hạn 1 giây, máy tính thông thường xử lý được khoảng 10^8 phép tính.
// Thuật toán này có độ phức tạp O(h^2) (do phải in h dòng, mỗi dòng 4h ký tự).
// Vì vậy, h tối đa khoảng 3,000 đến 5,000 để tổng số ký tự (4h^2) không vượt
// quá khả năng I/O và tính toán.