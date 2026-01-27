import java.util.*;

class EIUONCE {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for (int num : map.keySet()) {
                if (map.get(num) == 1) {
                    sb.append(num + " ");
                }

            }
            if (testcase > 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb); 
    }
}
