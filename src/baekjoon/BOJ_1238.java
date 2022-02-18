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

public class BOJ_1238 {

    private static Map<Integer, List<Edge>> graph;
    private static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int cityQuantity = Integer.parseInt(input[0]);
        int edgeQuantity = Integer.parseInt(input[1]);
        int partyLocation = Integer.parseInt(input[2]);

        graph = new HashMap<>();
        for (int i = 0; i < edgeQuantity; i++) {
            input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.putIfAbsent(start, new ArrayList<>());

            graph.get(start).add(new Edge(end, weight));
        }

        dist = new int[cityQuantity + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(partyLocation);
        int[] sumDist = dist.clone();

        for (int i = 1; i <= cityQuantity; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);
            sumDist[i] = sumDist[i] + dist[partyLocation];
        }

        int max = sumDist[1];
        for (int sum : sumDist) {
            if (sum == Integer.MAX_VALUE) {
                continue;
            }
            if (max < sum) {
                max = sum;
            }
        }

        System.out.println(max);
    }

    public static void dijkstra(int startNode) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        queue.add(new Edge(startNode, 0));
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            Edge poll = queue.poll();

            if (poll.getWeight() > dist[poll.getEnd()]) {
                continue;
            }

            List<Edge> edges = graph.get(poll.getEnd());
            if (edges != null) {
                for (Edge edge : edges) {
                    if (edge.getWeight() + poll.getWeight() < dist[edge.getEnd()]) {
                        dist[edge.getEnd()] = edge.getWeight() + poll.getWeight();
                        queue.add(new Edge(edge.getEnd(), dist[edge.getEnd()]));
                    }
                }
            }
        }
    }

    static class Edge {

        private int end;
        private int weight;

        public Edge(int edge, int weight) {
            this.end = edge;
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
