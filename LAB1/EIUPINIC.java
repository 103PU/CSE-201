
import java.util.Scanner;

public class EIUPINIC {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {

        int n = sc.nextInt();

        int[] group = new int[5];

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            group[temp]++;
        }

        int car = group[4] + group[3] + group[2] / 2;

        group[2] = group[2] % 2;

        group[1] = Math.max(0, group[1] - (group[3] + 2 * group[2]));

        if (group[2] > 0) {
            car++;
        }

        if (group[1] > 0) {
            car += (int) Math.ceil(group[1] / 4.0);
        }

        System.out.println(car);
    }
}
