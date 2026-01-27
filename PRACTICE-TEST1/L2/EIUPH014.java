import java.util.Scanner;

class EIUPH014 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            int loop = 0;
            while (loop <= 1000) {
                boolean isSame = true;

                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] != arr[i - 1]) {
                        isSame = false;
                        break;
                    }
                }
                arr = countDiff(arr);
                if (isSame) {
                    sb.append(loop).append("\n");
                    break;
                }
                loop++;
            }
            if (loop > 1000) {
                sb.append(-1).append("\n");
            }

        }

        System.out.println(sb);
    }

    public static int[] countDiff(int[] arr) {
        int[] temp = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            if (i < arr.length - 1) {
                temp[i - 1] = Math.abs(arr[i] - arr[i - 1]);
            } 
            if (i == arr.length - 1) {
                temp[arr.length - 1] = Math.abs(arr[arr.length - 1] - arr[0]);
            }
        }

        return temp;
    }
}
