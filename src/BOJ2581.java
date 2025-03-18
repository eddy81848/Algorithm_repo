package src;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int sum = 0;
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            for (int j = i * 2; j <= max; j += i) {
                prime[j] = false;
            }
        }

        boolean temp = true;
        int minPrime = 0;

        for (int i = 0; i <= max; i++) {
            if (prime[i] && i >= min) {
                if (temp) {
                    minPrime = i;
                    temp = false;
                }
                sum += i;
            }

        }
        if (sum != 0) {
            System.out.println(sum);
            System.out.println(minPrime);
        } else {
            System.out.println(-1);
        }

    }
}
