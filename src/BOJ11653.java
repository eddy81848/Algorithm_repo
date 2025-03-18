package src;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11653 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * 2; j <= n; j += i) {
                prime[j] = false;
            }
        }

        int index = 2;
        if (n != 1) {
            while (n != 0) {
                if (!prime[index]) {
                    index++;
                    continue;
                }
                if (n % index != 0) {
                    index++;
                    continue;
                }
                n /= index;
                System.out.println(index);
                if (n == 1) {
                    break;
                }
            }
        }

    }
}
