import java.util.Scanner;
import java.util.Stack;

class EIUBRACKET2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        while (n-- > 0) {

            String brackets = sc.next();
            if (brackets.length() % 2 != 0) {
                System.out.println("false");
                continue;
            }
            boolean check = true;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < brackets.length(); i++) {
                char value = brackets.charAt(i);
                if (value == '(' || value == '{' || value == '[') {
                    stack.push(value);

                } else if (value == ')' || value == '}' || value == ']') {
                    // check null string
                    if (stack.isEmpty()) {
                        check = false;
                        break;
                    }

                    else {

                        char open = stack.pop();

                        if (value == '}' && open != '{') {
                            check = false;
                            break;
                        }

                        else if (value == ']' && open != '[') {
                            check = false;
                            break;
                        } else if (value == ')' && open != '(') {
                            check = false;
                            break;
                        }
                    }

                }

            }

            if (check) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
}
