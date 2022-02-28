package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ_1325 {

    private static int n;
    private static int[] result;
    private static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList[n + 1];

        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a].add(b);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(result[i], max);
        }

        for (int i = 1; i < n + 1; i++) {
            if (max == result[i]) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n + 1];
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : map[now]) {
                if (!check[next]) {
                    check[next] = true;
                    result[next]++;
                    q.add(next);
                }
            }
        }
    }
}
