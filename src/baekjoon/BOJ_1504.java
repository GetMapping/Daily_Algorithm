package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BOJ_1504 {

    private static final int INF = 200000000;
    private static int nodeQuantity;
    private static int edgeQuantity;
    private static int mustPassNodeA;
    private static int mustPassNodeB;
    private static Map<Integer, List<Edge>> edges;
    private static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        nodeQuantity = Integer.parseInt(input[0]);
        edgeQuantity = Integer.parseInt(input[1]);

        edges = new HashMap<>();

        for (int i = 1; i <= nodeQuantity; i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edgeQuantity; i++) {
            input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            edges.get(start).add(new Edge(end, weight));
            edges.get(end).add(new Edge(start, weight));
        }

        input = bufferedReader.readLine().split(" ");
        mustPassNodeA = Integer.parseInt(input[0]);
        mustPassNodeB = Integer.parseInt(input[1]);

        //1 -> A -> B -> Target
        int answerAB = 0;
        answerAB += dijkstra(1, mustPassNodeA);
        answerAB += dijkstra(mustPassNodeA, mustPassNodeB);
        answerAB += dijkstra(mustPassNodeB, nodeQuantity);

        //1 -> B -> A -> Target
        int answerBA = 0;
        answerBA += dijkstra(1, mustPassNodeB);
        answerBA += dijkstra(mustPassNodeB, mustPassNodeA);
        answerBA += dijkstra(mustPassNodeA, nodeQuantity);

        if (answerAB >= INF && answerBA >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(answerAB, answerBA));
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        queue.add(new Edge(start, 0));

        dist = new int[nodeQuantity + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();
            int target = poll.getEnd();
            int targetWeight = poll.getWeight();

            if (targetWeight > dist[target]) {
                continue;
            }

            List<Edge> linked = edges.get(poll.getEnd());

            for (Edge next : linked) {
                int nextEnd = next.getEnd();
                int nextWeight = next.getWeight();

                if (targetWeight + nextWeight < dist[nextEnd]) {
                    dist[nextEnd] = targetWeight + nextWeight;
                    queue.add(new Edge(nextEnd, dist[nextEnd]));
                }
            }
        }

        return dist[end];
    }

    static class Edge {

        private int end;
        private int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
}

