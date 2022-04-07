package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cityQuantity = Integer.parseInt(bufferedReader.readLine());
        int busQuantity = Integer.parseInt(bufferedReader.readLine());

        int[][] map = new int[cityQuantity + 1][cityQuantity + 1];
        for (int i = 1; i < map.length; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][0] = 0;
            map[i][i] = 0;
        }

        for (int i = 0; i < busQuantity; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            map[start][end] = Math.min(map[start][end], weight);
        }

        for (int pass = 1; pass < map.length; pass++) {
            for (int i = 1; i < map.length; i++) {
                for (int j = 1; j < map[i].length; j++) {
                    if (map[i][pass] == Integer.MAX_VALUE || map[pass][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (map[i][j] > map[i][pass] + map[pass][j]) {
                        map[i][j] = map[i][pass] + map[pass][j];
                    }
                }
            }
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] >= Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

