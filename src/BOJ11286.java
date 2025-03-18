package src;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int temp;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int at = a;
            int bt = b;
            if (a < 0) a *= -1;
            if (b < 0) b *= -1;
            if (a == b) return at - bt;
            else return a - b;
        });
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (pq.size() == 0) sb.append("0").append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.add(temp);
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
