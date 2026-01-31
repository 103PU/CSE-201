import java.util.*;

class EI20213Q2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var n = sc.nextInt();
        Map<Integer, Integer> mapp = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            mapp.put(num, mapp.getOrDefault(num, 0) + 1);
        }

        for (var entry : mapp.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
