package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BOJ_1325 {

    private static boolean[] visited;
    private static HashMap<Integer, List<Integer>> nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        int quantity = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        nodes = new HashMap<>();

        for (int i = 1; i <= quantity; i++) {
            nodes.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            input = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            nodes.get(b).add(a);
        }

        int[] hack = new int[quantity + 1];
        int maxValue = 0;
        for (int i = 1; i <= quantity; i++) {
            visited = new boolean[quantity + 1];
            int hackQuantity = bfs(i);

            hack[i] = hackQuantity;
            if (hackQuantity > maxValue) {
                maxValue = hackQuantity;
            }
        }

        for (int i = 1; i < hack.length; i++) {
            if (hack[i] == maxValue) {
                System.out.print(i + " ");
            }
        }
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        int count = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer linked : nodes.get(poll)) {
                if (!visited[linked]) {
                    queue.add(linked);
                    visited[linked] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
//자바라서 시간초과란다....너무해...
