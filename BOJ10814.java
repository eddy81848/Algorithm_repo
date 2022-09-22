import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] age = new int[n][2];
        String[] name = new String[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            age[i][0] = Integer.parseInt(st.nextToken());
            age[i][1] = i;
            name[i] = st.nextToken();
        }
        Arrays.sort(age, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(age[i][0]).append(" ").append(name[age[i][1]]).append("\n");
        }
        bufferedWriter.write(String.valueOf(sb));
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
