import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.valueOf(bufferedReader.readLine()));
        }
        Collections.sort(list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            bufferedWriter.write(list.removeLast() + "\n");
        }
        bufferedWriter.flush();
    }
}
