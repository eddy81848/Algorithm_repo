package src;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1016 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        int result = (int) (max - min + 1);
        int count = 0;
        boolean[] sq = new boolean[result];
        Arrays.fill(sq, true);

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long i2 = i * i;
            long j = min / i2;
            if (min % i2 != 0) {
                j++;
            }
            long value = i2 * j;
            while (value <= max) {
                sq[(int) (value - min)] = false;
                value += i2;
            }
        }
        for (boolean b : sq) {
            if (b) count++;
        }
        System.out.println(count);
    }
}
