import java.util.*;

public class Q2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                if (arr.length == 1) {
                    sb.append(arr[i] + "\n");
                }

                // first
                if (i == 0 && arr[i] < arr[i + 1]) {
                    sb.append(arr[i] + " ");
                }
                // mid
                if (i > 0 && i < arr.length - 1 && arr[i] < arr[i + 1]) {
                    sb.append(arr[i] + " ");
                }

                // last
                if (i == arr.length - 1) {
                    if (arr[i] > arr[i - 1]) {
                        sb.append(arr[i]);
                    }
                }
            }

        }
        System.out.println(sb.toString());
    }
}
