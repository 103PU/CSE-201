import java.util.*;

class EIUDORM {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int roomLeft = sc.nextInt();
        int count = 0;
        for (int i = 0; i < roomLeft; i++) {
            int currentNumber = sc.nextInt();
            int maxNumber = sc.nextInt();
            if (maxNumber - currentNumber >= 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
