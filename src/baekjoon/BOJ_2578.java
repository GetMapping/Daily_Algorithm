package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class BOJ_2578 {

    private static int[][] map;
    private static HashMap<Integer, int[]> locations;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        locations = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(input[j]);
                map[i][j] = number;
                locations.put(number, new int[]{i, j});
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(input[j]);
                queue.add(number);
            }
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            Integer target = queue.poll();

            markNumber(target);
            answer++;

            if (answer >= 12 && isEnd()) {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void markNumber(int target) {
        int[] location = locations.get(target);
        map[location[0]][location[1]] = 0;
    }

    public static boolean isEnd() {
        int line = 0;

        for (int i = 0; i < 5; i++) {
            int wid = 0;
            int col = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) {
                    wid++;
                }

                if (map[j][i] == 0) {
                    col++;
                }
            }
            if (wid == 5) {
                line++;
            }
            if (col == 5) {
                line++;
            }
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == 0) {
                left++;
            }

            if (map[i][4 - i] == 0) {
                right++;
            }
        }

        if (left == 5) {
            line++;
        }
        if (right == 5) {
            line++;
        }

        return line >= 3;
    }
}
