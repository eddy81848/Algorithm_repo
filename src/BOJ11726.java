package src;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11726 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[1001];
        Arrays.fill(data, -1);
        System.out.println(fib(data, n));
    }

    public static int fib(int[] data, int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (data[n] == -1) {
            data[n] = (fib(data, n - 1) + fib(data, n - 2)) % 10007;
        }
        return data[n];
    }
}
