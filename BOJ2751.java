import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.addLast(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for (int m :
                list) {
            bw.write(m + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
