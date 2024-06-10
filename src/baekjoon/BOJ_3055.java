package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_3055 {

    private static final int[][] MOVE = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static final String CAN_NOT_GO = "KAKTUS";
    private static final String WATER = "*";
    private static final String ROCK = "X";
    private static final String ROAD = ".";
    private static final String END = "D";
    private static final String START = "S";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bufferedReader.readLine().split(" ");

        int r = Integer.parseInt(size[0]);
        int c = Integer.parseInt(size[1]);
        int[] startLocation = new int[2];
        int[] endLocation = new int[2];

        String[][] map = new String[r][c];
        for (int i = 0; i < r; i++) {
            String input = bufferedReader.readLine();
            map[i] = input.split("");
            if (input.contains(START)) {
                int j = input.indexOf(START);
                startLocation = new int[]{i, j};
            }
            if (input.contains(END)) {
                int j = input.indexOf(END);
                endLocation = new int[]{i, j};
            }
        }

        int[][] visited = new int[r][c];
        boolean[][] nextWater;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(startLocation);

        while (!queue.isEmpty()) {
            nextWater = findNextWater(map);
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            int nextCount = visited[nowX][nowY] + 1;

            for (int[] nextMove : MOVE) {
                int nextX = nowX + nextMove[0];
                int nextY = nowY + nextMove[1];

                if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
                    continue;
                }

                if (nextX == startLocation[0] && nextY == startLocation[1]) {
                    continue;
                }

                if (map[nextX][nextY].equals(WATER) || map[nextX][nextY].equals(ROCK)) {
                    continue;
                }

                if (nextWater[nextX][nextY]) {
                    continue;
                }

                if (visited[nextX][nextY] == 0 || visited[nextX][nextY] > nextCount) {
                    visited[nextX][nextY] = nextCount;
                }
                queue.add(new int[]{nextX, nextY});
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (nextWater[i][j]) {
                        map[i][j] = WATER;
                    }
                }
            }
        }

        int count = visited[endLocation[0]][endLocation[1]];
        if (count == 0 || count == -1) {
            System.out.println(CAN_NOT_GO);
        } else {
            System.out.println(count);
        }
    }

    private static boolean[][] findNextWater(String[][] map) {
        boolean[][] next = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j].equals(WATER)) {
                    for (int[] nextMove : MOVE) {
                        int nextX = i + nextMove[0];
                        int nextY = j + nextMove[1];

                        if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                            continue;
                        }

                        if (!map[nextX][nextY].equals(ROCK) && !map[nextX][nextY].equals(WATER)) {
                            next[nextX][nextY] = true;
                        }
                    }
                }
            }
        }

        return next;
    }
}
