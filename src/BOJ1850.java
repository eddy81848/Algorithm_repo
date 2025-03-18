package src;

import java.util.Scanner;

public class BOJ1850 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long gcd = GCD(a, b);
        String result = "1".repeat((int) gcd);
        System.out.println(result);
    }

    public static long GCD(long a, long b) {

        if (b == 0) return a;
        else {
            long r = a % b;
            return GCD(b, r);
        }
    }
}
