import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1850 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scanner.nextLine());
        String n = st.nextToken();
        String m = st.nextToken();
        for (int i = 0; i < Integer.parseInt(GCD(n, m)); i++) {
            System.out.print(1);
        }
    }

    public static String GCD(String n, String m) {
        if (compare(m, n)) {
            String temp = n;
            n = m;
            m = temp;
        }
        if (remainder(n, m).equals("0")) return m;
        else return GCD(m, remainder(n, m));
    }

    public static boolean compare(String a, String b) {
        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    return true;
                } else if (a.charAt(i) < b.charAt(i)) {
                    return false;
                }
            }
            return false;
        } else return a.length() > b.length();
    }

    public static String remainder(String n, String m) {
        StringBuilder a = new StringBuilder(n);
        StringBuilder b = new StringBuilder(m);
        StringBuilder result = new StringBuilder();
        String temp;
        int ai;
        int bi;
        if (a.length() == b.length()) {
            for (int i = a.length() - 1; i >= 0; i--) {
                ai = Integer.parseInt(String.valueOf(a.charAt(i)));
                bi = Integer.parseInt(String.valueOf(b.charAt(i)));
                if (ai >= bi) {
                    temp = Integer.toBinaryString(ai - bi);
                    result.append(temp);
                } else {
                   
                }
            }
        }
    }
}
