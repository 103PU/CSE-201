import java.util.*;

class EISWMED1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String b = sc.next();
        int k = sc.nextInt();

        int currentW = 0;
        for (int i = 0; i < k; i++) {
            if (b.charAt(i) == 'W') {
                currentW++;
            }
        }

        int minW = currentW;

        for (int i = k; i < b.length(); i++) {
            /* ptử cuối */
            if (b.charAt(i) == 'W') {
                currentW++;
            }
            /* ptử đầu */
            if (b.charAt(i - k) == 'W') {
                currentW--;
            }

            minW = Math.min(minW, currentW);

        }

        System.out.println(minW);

    }
}