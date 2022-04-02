package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_10282 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseQuantity = Integer.parseInt(bufferedReader.readLine());

        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        for (int test = 0; test < testCaseQuantity; test++) {
            graph = new HashMap<>();
            String[] input = bufferedReader.readLine().split(" ");

            int computerQuantity = Integer.parseInt(input[0]);
            int edgeQuantity = Integer.parseInt(input[1]);
            int zombieComputer = Integer.parseInt(input[2]);

            for (int i = 1; i <= computerQuantity; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < edgeQuantity; i++) {
                input = bufferedReader.readLine().split(" ");

                int computerA = Integer.parseInt(input[0]);
                int computerB = Integer.parseInt(input[1]);
                int sec = Integer.parseInt(input[2]);

                graph.get(computerB).add(new Edge(computerA, sec));
            }

            int[] answer = dijkstra(zombieComputer, graph, computerQuantity);
            System.out.println(answer[0] + " " + answer[1]);
        }
    }

    public static int[] dijkstra(int zombieComputer, HashMap<Integer, List<Edge>> graph, int computerQuantity) {
        int[] dist = new int[computerQuantity + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Edge> queue = new LinkedList<>();

        queue.add(new Edge(zombieComputer, 0));
        dist[zombieComputer] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();

            if (poll.sec > dist[poll.end]) {
                continue;
            }

            List<Edge> edges = graph.get(poll.end);
            for (Edge edge : edges) {
                if (poll.sec + edge.sec < dist[edge.end]) {
                    dist[edge.end] = poll.sec + edge.sec;
                    queue.add(new Edge(edge.end, dist[edge.end]));
                }
            }
        }

        int[] answer = getAnswer(dist);
        return answer;
    }

    public static int[] getAnswer(int[] dist) {
        int maxValue = 0;
        int cnt = 0;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                continue;
            }

            cnt++;
            if (dist[i] > maxValue) {
                maxValue = dist[i];
            }
        }

        return new int[]{cnt, maxValue};
    }

    static class Edge {

        int end;
        int sec;

        public Edge(int end, int sec) {
            this.end = end;
            this.sec = sec;
        }
    }
}

