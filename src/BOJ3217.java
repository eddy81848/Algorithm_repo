import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ3217 {
    public static ArrayList<int[]> memory = new ArrayList<>();//할당된 메모리 저장
    public static HashMap<String, Integer> map = new HashMap<>();//저장된 데이터와 메모리 인덱스 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        memory.add(new int[]{0, 0});
        memory.add(new int[]{100001, 100001});
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            try {
                StringTokenizer st = new StringTokenizer(s, "=");
                String var = st.nextToken();
                String command = st.nextToken();
                String tmp = command.substring(7, command.length() - 2);
                malloc(var, Integer.parseInt(tmp));
            } catch (Exception e) {
                if (s.startsWith("p")) {
                    String var = s.substring(6, s.length() - 2);
                    bw.write(print(var) + "\n");
                } else {
                    String var = s.substring(5, s.length() - 2);
                    free(var);
                }
            }

        }
        bw.flush();
        bw.close();
    }

    public static void malloc(String s, int n) {
        int iterator = memory.size();
        for (int i = 0; i < iterator - 1; i++) {
            int[] a = memory.get(i);
            int[] b = memory.get(i + 1);
            if ((b[0] - a[1] - 1) >= n) {
                memory.add(i + 1, new int[]{a[1] + 1, a[1] + n});
                for (String key : map.keySet()) {
                    int value = map.get(key);
                    if (value >= i + 1) {
                        map.put(key, value + 1);
                    }
                }
                map.put(s, i + 1);
                return;
            }
        }
        map.put(s, -1);
    }

    public static void free(String s) {
        try {
            int index = map.get(s);
            if (index != -1) {
                memory.remove(index);
                map.put(s, -1);
                for (String key : map.keySet()) {
                    int value = map.get(key);
                    if (value > index) {
                        map.put(key, value - 1);
                    }
                }
            }
        } catch (Exception e) {
            map.put(s, -1);
        }
    }

    public static int print(String s) {
        try {
            if (map.get(s) == -1) {
                return 0;
            } else {
                return memory.get(map.get(s))[0];
            }
        } catch (Exception e) {
            return 0;
        }
    }
}