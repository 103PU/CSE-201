import java.util.*;

public class EI20213Q2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Integer, Integer> mapp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            mapp.put(num, mapp.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mapp.entrySet()) {
            ans.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(ans.toString());
    }
}
