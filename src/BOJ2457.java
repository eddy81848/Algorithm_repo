import java.io.*;
import java.util.Arrays;

public class BOJ2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][2];
        int pointer = 0;
        int start = 301;
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            String[] tokens = st.split(" ");
            for (int j = 0; j < 4; j++) {
                if (tokens[j].length() == 1) {
                    tokens[j] = "0" + tokens[j];
                }
            }
            flowers[i][0] = Integer.parseInt(tokens[0] + tokens[1]);
            flowers[i][1] = Integer.parseInt(tokens[2] + tokens[3]);
        }

        Arrays.sort(flowers, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        while (start <= 1130) {
            flag = false;
            int max = Integer.MIN_VALUE;
            for (int i = pointer; i < n; i++) {
                if (flowers[i][0] > start) break;
                if (flowers[i][1] > max) {
                    max = flowers[i][1];
                    pointer = i + 1;
                    flag = true;
                }
            }
            if (flag) {
                start = max;
                cnt++;
            } else {
                break;
            }
        }
        if (flag) {
            bw.write(Integer.toString(cnt));
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
    }
}
