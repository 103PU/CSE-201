
import java.util.*;

class EIUPH011 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Map<Integer, Boolean> isContain = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (!isContain.containsKey(temp)) {
                sb.append(temp + " ");  
                isContain.put(temp, true);
            }
        }
        System.out.println(sb.toString());

    }
}