package src;

import java.io.*;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = arr[0];
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
        }
        int[] count = new int[max + 1];
        for (int a : arr) {
            count[a]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int a : sorted) {
            bw.write(a + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
