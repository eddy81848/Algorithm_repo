import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BOJ3015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Iterator<Integer> iterator = list.iterator();

        
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
}
