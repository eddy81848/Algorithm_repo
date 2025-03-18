import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeSet<Long> set = new TreeSet<>();
            HashMap<Long, Long> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                long l = Long.parseLong(st.nextToken());
                if (s.equals("I")) {
                    set.add(l);
                    map.put(l, map.getOrDefault(l, 0L) + 1);
                } else {
                    try {
                        long key;
                        if (l == 1) {
                            key = set.last();
                        } else {
                            key = set.first();
                        }
                        if (map.get(key) == 1) {
                            set.remove(key);
                            map.remove(key);
                        } else {
                            map.put(key, map.getOrDefault(key, 0L) - 1);
                        }
                    } catch (Exception e) {
                    }
                }
            }
            if (!set.isEmpty()) {
                bw.write(set.last() + " " + set.first() + "\n");
            } else {
                bw.write("EMPTY\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
