package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class BOJ_20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split("\\.");
            String extension = input[1];
            if (map.containsKey(extension)) {
                map.put(extension, map.get(extension) + 1);
            } else {
                map.put(extension, 1);
            }
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(String::compareTo);
        for (String key : keyList) {
            System.out.println(key + " " + map.get(key));
        }
    }
}

