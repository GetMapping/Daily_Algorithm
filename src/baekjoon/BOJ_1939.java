package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939 {

    private static HashMap<Integer, List<Edge>> graph;
    private static int factoryA;
    private static int factoryB;
    private static int answer = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int islandCnt = Integer.parseInt(stringTokenizer.nextToken());
        int edgeCnt = Integer.parseInt(stringTokenizer.nextToken());

        graph = new HashMap<>();
        for (int i = 1; i <= islandCnt; i++) {
            graph.put(i, new ArrayList<>());
        }

        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int i = 0; i < edgeCnt; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int islandA = Integer.parseInt(stringTokenizer.nextToken());
            int islandB = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(islandA).add(new Edge(islandB, weight));
            graph.get(islandB).add(new Edge(islandA, weight));

            min = Math.min(min, weight);
            max = Math.max(max, weight);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        factoryA = Integer.parseInt(stringTokenizer.nextToken());
        factoryB = Integer.parseInt(stringTokenizer.nextToken());

        while (min <= max) {
            int mid = (min + max) / 2;
            visited = new boolean[islandCnt + 1];

            if (bfs(mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean bfs(int mid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(factoryA);
        visited[factoryA] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if (temp == factoryB) {
                return true;
            }

            for (Edge edge : graph.get(temp)) {
                if (edge.weight >= mid && !visited[edge.end]) {
                    visited[edge.end] = true;
                    queue.add(edge.end);
                }
            }
        }

        return false;
    }


    static class Edge {

        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}

