package src;

public class BOJ11689 {
    public static void main(String[] args) {
        
    }

    public static int GCD(int n, int m) {
        if (m > n) {
            int temp = n;
            n = m;
            m = temp;
        }
        if (n % m == 0) return m;
        else return GCD(m, n % m);
    }

    public static int LCM(int n, int m) {
        return n * m / GCD(n, m);
    }
}
