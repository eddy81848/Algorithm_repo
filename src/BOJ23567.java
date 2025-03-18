import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ23567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            map2.put(arr[i], map2.getOrDefault(tmp, 0) + 1);
        }

        int pointer = 0;
        int min = Integer.MAX_VALUE;
        map.put(arr[pointer], 1);
        map2.put(arr[pointer], map2.get(arr[pointer]) - 1);
        if (map2.get(arr[pointer]) == 0) {
            map2.remove(arr[pointer]);
        }

        for (int i = 1; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                map2.put(arr[i], map2.get(arr[i]) - 1);
                if (map2.get(arr[i]) == 0) {
                    map2.remove(arr[i]);
                }
            } else if (arr[pointer] == arr[i]) {
                pointer++;

                while (map.get(arr[pointer]) > 1) {
                    map.put(arr[pointer], map.get(arr[pointer]) - 1);
                    map2.put(arr[pointer], map2.getOrDefault(arr[pointer], 0) + 1);
                    pointer++;
                }

            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                map2.put(arr[i], map2.getOrDefault(arr[i], 0) - 1);
                if (map2.get(arr[i]) == 0) {
                    map2.remove(arr[i]);
                }
            }

            if (map.size() == m) {

                int tmp = i - pointer + 1;
                if ((tmp < min) && (map2.size() == m)) {
                    min = tmp;
                }
            }

        }


        bw.write(min < Integer.MAX_VALUE ? Integer.toString(min) : "0");
        bw.flush();
        bw.close();
    }

}
