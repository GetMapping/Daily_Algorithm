package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_16234 {

    private static int[] moveHeight = {-1, 1, 0, 0};
    private static int[] moveWidth = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int size;
    private static int min;
    private static int max;
    private static int answer;
    private static int moveCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        size = Integer.parseInt(input[0]);
        min = Integer.parseInt(input[1]);
        max = Integer.parseInt(input[2]);

        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        answer = 0;

        while (true) {

            visited = new boolean[size][size];
            moveCnt = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if (moveCnt == 0) {
                break;
            }

            answer++;
        }

        System.out.println(answer);
    }

    public static void bfs(int startI, int startJ) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> moveAreas = new ArrayList<>();

        visited[startI][startJ] = true;
        queue.add(new int[]{startI, startJ});

        moveAreas.add(new int[]{startI, startJ});
        int sum = map[startI][startJ];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now = map[poll[0]][poll[1]];

            for (int i = 0; i < 4; i++) {
                int nextI = poll[0] + moveHeight[i];
                int nextJ = poll[1] + moveWidth[i];

                if (nextI < 0 || nextJ < 0 || nextI >= size || nextJ >= size) {
                    continue;
                }

                if (visited[nextI][nextJ]) {
                    continue;
                }

                int diff = Math.abs(now - map[nextI][nextJ]);
                if (min <= diff && diff <= max) {
                    sum += map[nextI][nextJ];
                    visited[nextI][nextJ] = true;
                    queue.add(new int[]{nextI, nextJ});
                    moveAreas.add(new int[]{nextI, nextJ});
                }
            }
        }

        move(moveAreas, sum / moveAreas.size());
    }

    public static void move(List<int[]> move, int count) {
        if (move.size() == 1) {
            return;
        }

        for (int i = 0; i < move.size(); i++) {
            int[] position = move.get(i);
            if (map[position[0]][position[1]] != count) {
                map[position[0]][position[1]] = count;
                moveCnt++;
            }
        }
    }
}

