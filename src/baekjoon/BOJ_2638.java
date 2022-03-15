package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2638 {

    private static int[] moveHeight = {-1, 1, 0, 0};
    private static int[] moveWidth = {0, 0, -1, 1};
    private static int height;
    private static int width;
    private static int[][] map;
    private static int[][] copyMap;
    private static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        map = new int[height][width];
        time = 0;

        for (int i = 0; i < height; i++) {
            input = bufferedReader.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (isCheeze()) {
            time++;
            airInit();
            pickCheeze();
            melt();
        }

        System.out.println(time);
    }

    public static void melt() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (copyMap[i][j] == 1) {
                    map[i][j] = -1;
                }
            }
        }
    }

    public static void pickCheeze() {
        boolean[][] visited = new boolean[height][width];
        copyMap = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int cnt = 0;

                    for (int location = 0; location < 4; location++) {
                        int nextI = i + moveHeight[location];
                        int nextJ = j + moveWidth[location];

                        if (!isInMap(nextI, nextJ)) {
                            continue;
                        }

                        if (visited[nextI][nextJ]) {
                            continue;
                        }

                        if (map[nextI][nextJ] == -1) {
                            cnt++;
                        }
                    }

                    if (cnt >= 2) {
                        copyMap[i][j] = 1;
                    }
                }
            }
        }
    }

    public static void airInit() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];

        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            map[poll[0]][poll[1]] = -1;

            for (int i = 0; i < 4; i++) {
                int nextI = poll[0] + moveHeight[i];
                int nextJ = poll[1] + moveWidth[i];

                if (!isInMap(nextI, nextJ)) {
                    continue;
                }

                if (visited[nextI][nextJ]) {
                    continue;
                }

                if (map[nextI][nextJ] == 0 || map[nextI][nextJ] == -1) {
                    map[nextI][nextJ] = -1;
                    queue.add(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }
    }

    public static boolean isInMap(int i, int j) {
        if (i < 0 || j < 0 || i >= height || j >= width) {
            return false;
        }
        return true;
    }

    public static boolean isCheeze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}

