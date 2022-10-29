import java.util.Scanner;

public class BOJ1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = n; i <= m; i++) {
            boolean t = true;
            if (i == 2) {
                System.out.println(2);
                continue;
            }
            if (i == 1) continue;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    t = false;
                    break;
                }
            }
            if (t) System.out.println(i);
        }
    }
}
