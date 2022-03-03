package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BOJ_2636 {

    private static int height, width;
    private static int[][] map;
    private static boolean[][] visited;
    private static int cheezeCnt;
    private static int time;
    private static int[] moveHeight = {-1, 1, 0, 0};
    private static int[] moveWidth = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        map = new int[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        cheezeCnt = 0;
        time = 0;

        while (isCheeze()) {
            visited = new boolean[height][width];
            time++;

            visited[0][0] = true;
            cheezeCnt = 0;

            DFS(0, 0);
        }

        System.out.println(time);
        System.out.println(cheezeCnt);
    }

    public static boolean isCheeze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void DFS(int i, int j) {
        for (int location = 0; location < 4; location++) {
            int nextHeight = i + moveHeight[location];
            int nextWidth = j + moveWidth[location];

            if (nextHeight < 0 || nextWidth < 0 || nextHeight >= height || nextWidth >= width) {
                continue;
            }

            if (!visited[nextHeight][nextWidth]) {
                visited[nextHeight][nextWidth] = true;
                if (map[nextHeight][nextWidth] == 1) {
                    map[nextHeight][nextWidth] = 2;
                    cheezeCnt++;
                } else {
                    DFS(nextHeight, nextWidth);
                }
            }
        }
    }
}

