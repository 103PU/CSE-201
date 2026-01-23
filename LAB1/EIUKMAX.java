
import java.util.*;

class EIUKMAX {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arrayNumber = new int[n];
        for (int i = 0; i < arrayNumber.length; i++) {
            arrayNumber[i] = sc.nextInt();
        }
        Arrays.sort(arrayNumber);

        for (int i = arrayNumber.length - 1; i >= arrayNumber.length - k; i--) {
            sb.append(arrayNumber[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
