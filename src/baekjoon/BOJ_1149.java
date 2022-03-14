package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1149 {

    private static int N;
    private static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] input = bufferedReader.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                if (i != 0) {
                    if (j == 0) {
                        cost[i][j] = Math.min(cost[i - 1][1], cost[i - 1][2]) + Integer.parseInt(input[j]);
                        continue;
                    }
                    if (j == 1) {
                        cost[i][j] = Math.min(cost[i - 1][0], cost[i - 1][2]) + Integer.parseInt(input[j]);
                        continue;
                    }
                    if (j == 2) {
                        cost[i][j] = Math.min(cost[i - 1][0], cost[i - 1][1]) + Integer.parseInt(input[j]);
                        continue;
                    }
                } else {
                    cost[i][j] = Integer.parseInt(input[j]);
                }
            }
        }

        int answer = Math.min(cost[N - 1][0], Math.min(cost[N - 1][1], cost[N - 1][2]));
        System.out.println(answer);
    }
}
