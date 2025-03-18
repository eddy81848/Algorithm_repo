package src;

import java.util.Scanner;

public class BOJ1747 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (true) {
            if (isPalindrome(m)) {
                if (isPrime(m)) {
                    System.out.println(m);
                    break;
                }
            }
            m++;
        }
    }

    public static boolean isPalindrome(int i) {
        String test = Integer.toString(i);
        int start = 0;
        int end = test.length() - 1;
        boolean isP = true;
        while (start < end) {
            if (test.charAt(start) != test.charAt(end)) {
                isP = false;
                break;
            }
            start++;
            end--;
        }
        return isP;
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
        }
        return true;
    }
}
