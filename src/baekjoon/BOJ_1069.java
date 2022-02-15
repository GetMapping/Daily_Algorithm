package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class BOJ_1069 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int quantity = Integer.parseInt(input[0]);
        int length = Integer.parseInt(input[1]);

        String[][] DNAs = new String[length][quantity];
        for (int i = 0; i < quantity; i++) {
            String[] DNA = bufferedReader.readLine().split("");
            for (int j = 0; j < length; j++) {
                DNAs[j][i] = DNA[j];
            }
        }

        StringBuilder targetDNA = new StringBuilder();
        Map<String, Integer> counts;
        for (int i = 0; i < length; i++) {
            counts = new HashMap<>();
            counts.putIfAbsent("A", 0);
            counts.putIfAbsent("T", 0);
            counts.putIfAbsent("G", 0);
            counts.putIfAbsent("C", 0);

            for (int j = 0; j < quantity; j++) {
                if (DNAs[i][j].equals("A")) {
                    counts.put("A", counts.get("A") + 1);
                    continue;
                }
                if (DNAs[i][j].equals("C")) {
                    counts.put("C", counts.get("C") + 1);
                    continue;
                }
                if (DNAs[i][j].equals("G")) {
                    counts.put("G", counts.get("G") + 1);
                    continue;
                }
                if (DNAs[i][j].equals("T")) {
                    counts.put("T", counts.get("T") + 1);
                }
            }
            targetDNA.append(findMaxString(counts));
        }

        String[] target = targetDNA.toString().split("");

        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < quantity; j++) {
                if (!target[i].equals(DNAs[i][j])) {
                    sum++;
                }
            }
        }

        System.out.println(targetDNA);
        System.out.println(sum);
    }

    public static String findMaxString(Map<String, Integer> counts) {
        String maxString = "A";
        int max = counts.get("A");

        String[] keys = counts.keySet().toArray(String[]::new);
        for (String key : keys) {
            Integer count = counts.get(key);
            if (count > max) {
                maxString = key;
                max = count;
            }
        }

        return maxString;
    }

}
