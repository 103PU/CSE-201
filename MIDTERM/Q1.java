
import java.util.Arrays;
import java.util.Scanner;

class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of gifts
        int m = sc.nextInt(); // number of papers
        long K = sc.nextLong();

        long[] gifts = new long[n];
        long[] papers = new long[m];

        for (int i = 0; i < n; i++)
            gifts[i] = sc.nextLong();
        for (int i = 0; i < m; i++)
            papers[i] = sc.nextLong();

        Arrays.sort(gifts);
        Arrays.sort(papers);

        int i = 0; // gift pointer
        int j = 0; // paper pointer
        int count = 0;

        while (i < n && j < m) {
            long max = gifts[i] * 3;
            long min = gifts[i] * 2;

            if (papers[j] >= min && papers[j] <= max) {
                count++;
                i++;
                j++;
            } else if (papers[j] < min) {
                long need = min - papers[j];
                if (K >= need) {
                    count++;
                    i++;
                    j++;
                } else {
                    j++;
                }
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
