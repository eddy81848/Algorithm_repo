import java.io.*;

public class BOJ2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] flowers = new int[n][2];
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
        
    }
}
