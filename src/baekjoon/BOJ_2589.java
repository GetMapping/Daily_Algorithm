package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2589 {

    private static int height;
    private static int width;
    private static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        map = new String[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = bufferedReader.readLine().split("");
        }

        int answer = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j].equals("L")) {
                    int max = bfs(i, j);
                    answer = Math.max(max, answer);
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int startI, int startJ) {
        int[] moveHeight = {-1, 1, 0, 0};
        int[] moveWidth = {0, 0, 1, -1};
        boolean[][] visited = new boolean[height][width];
        int max = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startI, startJ, 0});
        visited[startI][startJ] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowI = poll[0];
            int nowJ = poll[1];
            int weight = poll[2];

            max = Math.max(weight, max);

            for (int i = 0; i < 4; i++) {
                int nextI = nowI + moveHeight[i];
                int nextJ = nowJ + moveWidth[i];

                if (nextI < 0 || nextJ < 0 || nextI >= height || nextJ >= width) {
                    continue;
                }

                if (visited[nextI][nextJ]) {
                    continue;
                }

                if (map[nextI][nextJ].equals("L")) {
                    queue.add(new int[]{nextI, nextJ, weight + 1});
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return max;
    }
}

