package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        permute(new boolean[n + 1], new int[n], 0, n, n);
    }

    private static void permute(boolean[] visited, int[] answer, int dept, int n, int r) {
        if (dept == r) {
            for (int i : answer) {
                System.out.print((i + 1) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[dept] = i;
                permute(visited, answer, dept + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
