package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14502 {

    private static int[] moveHeight = {-1, 1, 0, 0};
    private static int[] moveWidth = {0, 0, -1, 1};
    private static int height;
    private static int width;
    private static int max;
    private static int[][] originalMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        originalMap = new int[height][width];
        max = 0;

        for (int i = 0; i < height; i++) {
            input = bufferedReader.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                originalMap[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            max = Math.max(bfs(), max);
            return;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    dfs(depth + 1);
                    originalMap[i][j] = 0;
                }
            }
        }
    }

    public static int bfs() {
        int[][] spreadMap = copyMap(originalMap);
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (spreadMap[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowI = poll[0];
            int nowJ = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextI = nowI + moveHeight[i];
                int nextJ = nowJ + moveWidth[i];

                if (!isInBound(nextI, nextJ)) {
                    continue;
                }

                if (visited[nextI][nextJ]) {
                    continue;
                }

                if (spreadMap[nextI][nextJ] == 0) {
                    spreadMap[nextI][nextJ] = 2;
                    queue.add(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return countArea(spreadMap);
    }

    public static int countArea(int[][] spreadMap) {
        int cnt = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (spreadMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int[][] copyMap(int[][] map) {
        int[][] copy = new int[height][width];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                copy[i][j] = map[i][j];
            }
        }

        return copy;
    }

    public static boolean isInBound(int i, int j) {
        if (i < 0 || j < 0 || i >= height || j >= width) {
            return false;
        }

        return true;
    }

}

