import java.util.Scanner;

public class BOJ1541 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int sum = 0;
        int tempSum = 0;
        int multi = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char temp = s.charAt(i);
            if (temp != '+' && temp != '-') {
                tempSum += Integer.parseInt(String.valueOf(temp)) * multi;
                multi *= 10;
            } else if (temp == '+') {
                multi = 1;
            } else {
                sum -= tempSum;
                multi = 1;
                tempSum = 0;
            }
        }
        sum += tempSum;
        System.out.println(sum);
    }
}
