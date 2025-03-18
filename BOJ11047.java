import java.util.Scanner;

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] value = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            result += m / value[i];
            m %= value[i];
        }
        
        System.out.println(result);
    }
}