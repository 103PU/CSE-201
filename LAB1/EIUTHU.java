
import java.util.Scanner;

class EIUTHU {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String string1 = sc.next();
        String string2 = sc.next();
        int duplicated = 0;

        for (int i = Math.min(string1.length(), string2.length()); i > 0; i--) {
            if (string1.substring(string1.length() - i).equals(string2.substring(0, i))) {
                duplicated = i;
                break;
            }
        }

        int string_length = string1.length() + string2.length() - duplicated;

        System.out.println(string_length);
        // option in ra letter trừ phần lặp
        // String string3 = string2.substring(duplicated,string2.length());
        // System.out.println(string1+string3);
    }
}
