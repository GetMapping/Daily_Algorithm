package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int nodeQuantity = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[nodeQuantity][nodeQuantity];

        for (int i = 0; i < nodeQuantity; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        for (int pass = 0; pass < nodeQuantity; pass++) {
            for (int i = 0; i < nodeQuantity; i++) {
                for (int j = 0; j < nodeQuantity; j++) {
                    if (map[i][pass] == 1 && map[pass][j] == 1) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

