import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int n = scanner.nextInt();
        String s;
        for (int i = 0; i < n; i++) {
            s = scanner.next();
            boolean vps = true;
            for (int j = 0; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case '(':
                        stack.push(s.charAt(j));
                        break;
                    case ')':
                        try {
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                vps = false;
                            }
                            break;
                        } catch (EmptyStackException e) {
                            vps = false;
                            break;
                        }
                }
                if (!vps) break;
            }
            if (!stack.empty()) vps = false;
            if (vps) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            stack.clear();
        }
    }
}
