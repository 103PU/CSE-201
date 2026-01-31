import java.io.*;
import java.util.*;

class EIUPH011 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Set<Integer> isAvailable = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (!isAvailable.contains(temp)) {
                sb.append(temp + " ");
                isAvailable.add(temp);
            }
        }

        System.out.println(sb.toString());

    }
}