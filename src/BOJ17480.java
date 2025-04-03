import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ17480 {
    public static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int front = 0;
        int rear = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            rear += cnt;
            map.put(s, cnt);
        }
        String word = br.readLine();
        HashMap<String, Integer> tmpMap = new HashMap<>(map);
        LinkedList<String> subStrings = new LinkedList<>();

        for (int i = 0; i < rear; i++) {
            String now = Character.toString(word.charAt(i));
            if (tmpMap.containsKey(now)) {
                tmpMap.put(now, tmpMap.get(now) - 1);
            }
        } //초기 substring 확인
        boolean tmp = true;
        for (int i : tmpMap.values()) {
            if (i != 0) {
                tmp = false;
                break;
            }
        }

        if (tmp) {
            subStrings.add(word.substring(front, rear));
        } //초기에 완성 되었으면 LinkedList에 넣기

        for (; rear < word.length(); rear++, front++) {
            String frontStr = Character.toString(word.charAt(front));
            String rearStr = Character.toString(word.charAt(rear));
            if (map.containsKey(frontStr)) {
                tmpMap.put(frontStr, tmpMap.getOrDefault(frontStr, 0) + 1);
            }

            if (map.containsKey(rearStr)) {
                tmpMap.put(rearStr, tmpMap.get(rearStr) - 1);
            }
            tmp = true;
            for (int i : tmpMap.values()) {
                if (i != 0) {
                    tmp = false;
                    break;
                }
            }
            if (tmp) {
                subStrings.add(word.substring(front + 1, rear + 1));
            }
        } //슬라이딩 윈도우로 substring 확인


        for (String s : subStrings) {
            recursion(s, new StringBuilder(s), 0, s.length() - 1);
        }

        bw.write(Integer.toString(set.size()));
        bw.flush();
        bw.close();
    }

    public static void recursion(String word, StringBuilder sb, int start, int end) {
        StringBuilder tmpSb;
        String tmpStr = sb.toString();
        if (start >= end) {
            set.add(sb.toString());
            return;
        }
        if ((end - start + 1) % 2 == 0) {
            //앞을 역순
            tmpSb = new StringBuilder(tmpStr);
            tmpSb.replace(start, (start + end) / 2 + 1, subStringReverse(tmpSb, start, (start + end) / 2));
            recursion(word, tmpSb, (start + end) / 2 + 1, end);
            //뒤를 역순
            tmpSb = new StringBuilder(tmpStr);
            tmpSb.replace((start + end) / 2 + 1, end + 1, subStringReverse(tmpSb, (start + end) / 2 + 1, end));
            recursion(word, tmpSb, start, (start + end) / 2);
        } else {
            //앞이 적을 때
            //앞이 역순
            tmpSb = new StringBuilder(tmpStr);
            tmpSb.replace(start, (start + end) / 2, subStringReverse(tmpSb, start, (start + end) / 2 - 1));
            recursion(word, tmpSb, (start + end) / 2, end);
            //뒤가 역순
            tmpSb = new StringBuilder(tmpStr);
            tmpSb.replace((start + end) / 2, end + 1, subStringReverse(tmpSb, (start + end) / 2, end));
            recursion(word, tmpSb, start, (start + end) / 2 - 1);
            //뒤가 적을 때
            //앞이 역순
            tmpSb = new StringBuilder(tmpStr);
            tmpSb.replace(start, (start + end) / 2 + 1, subStringReverse(tmpSb, start, (start + end) / 2));
            recursion(word, tmpSb, (start + end) / 2 + 1, end);
            //뒤가 역순
            tmpSb = new StringBuilder(tmpStr);
            tmpSb.replace((start + end) / 2 + 1, end + 1, subStringReverse(tmpSb, (start + end) / 2 + 1, end));
            recursion(word, tmpSb, start, (start + end) / 2);
        }
    }

    public static String subStringReverse(StringBuilder sb, int start, int end) {
        //범위만큰 문자열 뒤집는 함수
        String s = sb.substring(start, end + 1);
        StringBuilder sbReverse = new StringBuilder(s);
        sbReverse.reverse();
        return sbReverse.toString();
    }
}
