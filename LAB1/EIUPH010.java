
import java.util.Scanner;

class EIUPH010 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        int n = sc.nextInt();
        int[] isExisted = new int[1_000_001];
        int[] number = new int[n];
        int maxcount = 0;
        int maxnum = -1;
        for (int i = 0; i < n; i++) {
            number[i] = sc.nextInt();
            isExisted[number[i]]++;

        }
        for (int i = 0; i < isExisted.length; i++) {
            if (isExisted[i] > maxcount) {
                maxcount = isExisted[i];
                maxnum = i;
            }
        }
        System.out.println(maxnum + " " + maxcount);

    }
}