package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1018 {

    private static int height;
    private static int width;
    private static String[][] map;
    private static String[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);

        map = new String[height][width];
        copyMap = new String[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = bufferedReader.readLine().split("");
        }

        makeStartWithBlack();
        int startWithBlack = compareWithCopyMap();
        makeStartWithWhite();
        int startWithWhite = compareWithCopyMap();

        System.out.println(Math.min(startWithBlack, startWithWhite));
    }

    public static void makeStartWithBlack() {
        for (int line = 0; line < height; line++) {
            for (int idx = 0; idx < width; idx++) {
                if ((line % 2 == 0 && idx % 2 == 0) || (line % 2 == 1 && idx % 2 == 1)) {
                    copyMap[line][idx] = "B";
                } else {
                    copyMap[line][idx] = "W";
                }
            }
        }
    }

    public static void makeStartWithWhite() {
        for (int line = 0; line < height; line++) {
            for (int idx = 0; idx < width; idx++) {
                if ((line % 2 == 0 && idx % 2 == 0) || (line % 2 == 1 && idx % 2 == 1)) {
                    copyMap[line][idx] = "W";
                } else {
                    copyMap[line][idx] = "B";
                }
            }
        }
    }

    public static int compareWithCopyMap() {
        int min = Integer.MAX_VALUE;

        for (int startline = 0; startline < height - 7; startline++) {
            for (int startIdx = 0; startIdx < width - 7; startIdx++) {
                int count = compare(startline, startIdx);
                min = Math.min(min, count);
            }
        }

        return min;
    }

    public static int compare(int startLine, int startIdx) {
        int count = 0;

        for (int line = startLine; line < startLine + 8; line++) {
            for (int idx = startIdx; idx < startIdx + 8; idx++) {
                if (!map[line][idx].equals(copyMap[line][idx])) {
                    count++;
                }
            }
        }

        return count;
    }
}

