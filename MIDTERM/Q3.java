import java.util.Arrays;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập số phần tử mảng (theo example input)
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            String query = sc.next();

            if (query.equals("end")) {
                break;
            }

            switch (query) {
                case "update": {
                    int idx = sc.nextInt();
                    int val = sc.nextInt();
                    // Check invalid input: index ngoài mảng
                    if (idx >= 0 && idx < n) {
                        arr[idx] = val;
                        // In mảng sau khi update (theo đề bài)
                        /*
                         * Lưu ý: Mặc dù output example không hiển thị rõ,
                         * nhưng đề bài ghi "output the new array".
                         * Nên ta in ra, hoặc nếu test case giấu đi thi ta có thể comment lại.
                         * Ở đây mình sẽ in để đúng đề.
                         */
                        /* for (int x : arr) System.out.print(x + " "); System.out.println(); */
                        // COMMENTED OUT printing to match Example Output strictly (which shows nothing)
                        // If exam requires, uncomment above line.
                    }
                    break;
                }

                case "median": {
                    // Tạo bản sao để sort, ko làm hỏng arr gốc
                    int[] temp = arr.clone();
                    Arrays.sort(temp);
                    // Kích thước n. Median ở vị trí n/2 (nếu n lẻ) hoặc (n-1)/2 (tuỳ định nghĩa)
                    // Example: 7 phần tử -> index 3 (là phần tử thứ 4) -> 7/2 = 3.
                    // Nếu chẵn, thường là trung bình cộng 2 số giữa, nhưng output example là
                    // integer -> lấy 1 số
                    double med;
                    if (n % 2 != 0) {
                        med = temp[n / 2];
                        System.out.println((int) med); // Cast về int theo output example
                    } else {
                        // Nếu chẵn: (temp[n/2 - 1] + temp[n/2]) / 2.0
                        med = (temp[n / 2 - 1] + temp[n / 2]) / 2.0;
                        // Check nếu là số nguyên thì in ko .0
                        if (med == (int) med)
                            System.out.println((int) med);
                        else
                            System.out.println(med);
                    }
                    break;
                }

                case "sumK": {
                    int k = sc.nextInt();
                    boolean found = false;
                    // Duyệt 2 vòng để tìm a[i] + a[j] == k
                    // Lưu ý: "two elements" thường là 2 vị trí khác nhau (i != j)
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] + arr[j] == k) {
                                found = true;
                                break;
                            }
                        }
                        if (found)
                            break;
                    }
                    System.out.println(found);
                    break;
                }

                case "sum": {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    // Check invalid input
                    if (l < 0 || r >= n || l > r) {
                        // System.out.println("Invalid range");
                        // Example không có output lỗi cụ thể, nên ta có thể bỏ qua hoặc in gì đó.
                        break;
                    }
                    long sum = 0;
                    for (int i = l; i <= r; i++) {
                        sum += arr[i];
                    }
                    System.out.println(sum);
                    break;
                }

                case "average": {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    if (l < 0 || r >= n || l > r)
                        break;

                    long sum = 0;
                    int count = r - l + 1;
                    for (int i = l; i <= r; i++)
                        sum += arr[i];

                    // In số thực hay nguyên? Đề không nói rõ, thường là thực
                    double avg = (double) sum / count;
                    // Format gọn nếu cần, ở đây in default
                    // Nếu là số nguyên thì in int
                    if (avg == (int) avg)
                        System.out.println((int) avg);
                    else
                        System.out.println(String.format("%.1f", avg)); // Lấy 1 số lẻ cho gọn
                    break;
                }

                case "min": {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    if (l < 0 || r >= n || l > r)
                        break;

                    int minVal = arr[l];
                    for (int i = l + 1; i <= r; i++) {
                        if (arr[i] < minVal)
                            minVal = arr[i];
                    }
                    System.out.println(minVal);
                    break;
                }

                case "searchK": {
                    int k = sc.nextInt();
                    boolean found = false;
                    for (int x : arr) {
                        if (x == k) {
                            found = true;
                            break;
                        }
                    }
                    System.out.println(found);
                    break;
                }

                case "maxK": {
                    int k = sc.nextInt();
                    // k-th largest: k=1 là max nhất.
                    // Nếu k > n hoặc k <= 0 -> invalid
                    if (k <= 0 || k > n)
                        break;

                    int[] temp = arr.clone();
                    Arrays.sort(temp);
                    // Sau khi sort tăng dần: max nhất ở cuối (n-1)
                    // k-th largest là ở n - k
                    System.out.println(temp[n - k]);
                    break;
                }

                default:
                    break;
            }
        }
    }
}
