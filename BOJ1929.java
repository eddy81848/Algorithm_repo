import java.util.Scanner;

public class BOJ1929 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        boolean[] prime = new boolean[max + 1];
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            for (int j = i * 2; j <= max; j += i) {
                prime[j] = true;
            }
        }
        for (int i = min; i <= max; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }
    }
}
