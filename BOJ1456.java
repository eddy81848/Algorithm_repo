import java.util.Arrays;
import java.util.Scanner;

public class BOJ1456 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        int cnt = 0;
        int sqrtMax = (int) Math.sqrt(max);
        boolean[] prime = new boolean[sqrtMax + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(sqrtMax); i++) {
            for (int j = i * 2; j <= sqrtMax; j += i) {
                prime[j] = false;
            }
        }

        int temp;

        for (long i = 2; i <= sqrtMax; i++) {
            if (prime[(int) i]) {
                for (long j = i * i; j <= max; j *= i) {
                    if (j >= min) {
                        cnt++;
                    }
                    temp = ((int) Math.log10(j) + 1) + ((int) Math.log10(i) + 1);
                    if (temp > 15) {
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
