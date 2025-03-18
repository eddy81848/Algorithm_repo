import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public class BOJ6443 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        for (int i = 0; i < n; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (String str : arr[i].split("")) {
                if (map.containsKey(str)) {
                    map.compute(str, (k, m) -> m + 1);
                } else {
                    map.put(str, 1);
                }
            }
            anagram(map, sb, list);
        }
        list.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });
        for (String str : list) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void anagram(HashMap<String, Integer> map, StringBuilder sb, LinkedList<String> list) {
        if (!map.isEmpty()) {
            for (String s : map.keySet()) {
                StringBuilder sb2 = new StringBuilder(sb);
                int n = map.get(s);
                sb2.append(s);
                HashMap<String, Integer> map2 = new HashMap<>(map);
                if (n == 1) {
                    map2.remove(s);
                } else {
                    map2.put(s, n - 1);
                }
                anagram(map2, sb2, list);
            }
        } else {
            list.add(sb.toString());
        }
    }
}
