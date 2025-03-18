import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class BOJ4949 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if (Objects.equals(s, ".")) {
                break;
            }
            LinkedList<Character> stack = new LinkedList<>();
            boolean balance = true;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(':
                    case '[':
                        stack.addLast(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peekLast() == '(') {
                            stack.removeLast();
                            break;
                        } else {
                            System.out.println("no");
                            balance = false;
                            break;
                        }
                    case ']':
                        if (!stack.isEmpty() && stack.peekLast() == '[') {
                            stack.removeLast();
                            break;
                        } else {
                            System.out.println("no");
                            balance = false;
                            break;
                        }
                }
                if (!balance) break;
            }
            if (balance) {
                if (stack.isEmpty()) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
