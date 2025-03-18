import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        String s = bufferedReader.readLine();
        for (int i = 0; i < s.length(); i++) {
            list.addLast(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.getLast());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
