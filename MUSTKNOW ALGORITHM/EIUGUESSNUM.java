import java.util.*;

class EIUGUESSNUM {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        // long rage = b - a;
        // long[] numrange = new long[(int) rage + 1];
        String ans;
        long low = a;
        long high = b;
        int count = 1;

        while (a <= b && count <= 100) {
            long mid = low + (high - low) / 2;
            System.out.println(mid);
            System.out.flush();

            ans = sc.next();
            if (ans.equals("WIN")) {
                break;
            } else if (ans.equals("HIGH")) {
                high = mid - 1;
            } else if (ans.equals("LOW")) {
                low = mid + 1;
            }
            count++;
        }

        sc.close();

    }

}