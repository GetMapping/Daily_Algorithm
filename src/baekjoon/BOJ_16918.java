package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16918 {

    private static int[] moveHeight = {1, -1, 0, 0};
    private static int[] moveWidth = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int height = Integer.parseInt(inputs[0]);
        int width = Integer.parseInt(inputs[1]);
        int targetTime = Integer.parseInt(inputs[2]);

        char[][] map = new char[height][width];
        int[][] bombTime = new int[height][width];

        for (int i = 0; i < height; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = tmp.charAt(j);
                if (map[i][j] == 'O') {
                    bombTime[i][j] = 3;
                }
            }
        }

        int time = 0;

        while (time++ < targetTime) {
            if (time % 2 == 0) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombTime[i][j] = time + 3;
                        }
                    }
                }
            } else if (time % 2 == 1) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (bombTime[i][j] == time) {
                            map[i][j] = '.';
                            for (int d = 0; d < 4; d++) {
                                int nextHeight = i + moveHeight[d];
                                int nextWidth = j + moveWidth[d];

                                if (nextHeight < 0 || nextWidth < 0 || nextHeight >= height || nextWidth >= width) {
                                    continue;
                                }

                                if (map[nextHeight][nextWidth] == 'O' && bombTime[nextHeight][nextWidth] != time) {
                                    map[nextHeight][nextWidth] = '.';
                                    bombTime[nextHeight][nextWidth] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            System.out.println(map[i]);
        }
    }
}
