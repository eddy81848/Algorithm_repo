

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long result = dp(n, p, q, map);
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }

    public static long dp(long n, long p, long q, HashMap<Long, Long> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            long tmp = dp(n / p, p, q, map) + dp(n / q, p, q, map);
            map.put(n, tmp);
            return tmp;
        }
    }
}