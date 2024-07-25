package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BOJ_1260 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] first = bufferedReader.readLine().split(" ");
        int nodeCnt = Integer.parseInt(first[0]);
        int edgeCnt = Integer.parseInt(first[1]);
        int startNode = Integer.parseInt(first[2]);

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= nodeCnt; i++) {
            graph.put(i, new LinkedList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(dfs(new boolean[nodeCnt + 1], startNode, graph));
        System.out.println(bfs(new boolean[nodeCnt + 1], startNode, graph));

    }

    private static String dfs(boolean[] visited, int start, HashMap<Integer, List<Integer>> graph) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Integer target = stack.pop();
            if (!visited[target]) {
                sb.append(target + " ");
                visited[target] = true;
            }

            Collections.sort(graph.get(target), Collections.reverseOrder());

            for (Integer nextNode : graph.get(target)) {
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                }
            }
        }

        return sb.toString();
    }

    private static String bfs(boolean[] visited, int start, HashMap<Integer, List<Integer>> graph) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer target = queue.poll();
            sb.append(target + " ");

            Collections.sort(graph.get(target));

            for (Integer nextNode : graph.get(target)) {
                if (!visited[nextNode]) {
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        return sb.toString();
    }
}
