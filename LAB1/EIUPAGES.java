import java.io.*;
import java.util.*;

class EIUPAGES {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (r < n && arr[l] + 1 == arr[r]) {
                l++;
                r++;
            }
            if (l - i > 1) {
                sb.append(arr[i]).append("-").append(arr[l]).append(" ");
            } else if (l - i == 1) {
                sb.append(arr[i]).append(" ").append(arr[l]).append(" ");
            } else {
                sb.append(arr[i]).append(" ");
            }
            i = l;
        }
        System.out.println(sb);
    }

}