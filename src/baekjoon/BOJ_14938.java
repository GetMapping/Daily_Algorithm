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

public class BOJ_14938 {

    private static int cityQuantity;
    private static int seekBound;
    private static int roadQuantity;
    private static int[] items;
    private static int[] dist;
    private static Map<Integer, List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        cityQuantity = Integer.parseInt(input[0]);
        seekBound = Integer.parseInt(input[1]);
        roadQuantity = Integer.parseInt(input[2]);

        items = new int[cityQuantity + 1];
        graph = new HashMap<>();

        for (int i = 1; i <= cityQuantity; i++) {
            graph.put(i, new ArrayList<>());
        }

        input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            items[i + 1] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < roadQuantity; i++) {
            input = bufferedReader.readLine().split(" ");
            int targetA = Integer.parseInt(input[0]);
            int targetB = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.get(targetA).add(new Edge(targetB, weight));
            graph.get(targetB).add(new Edge(targetA, weight));
        }

        int max = 0;

        for (int i = 1; i <= cityQuantity; i++) {
            dist = new int[cityQuantity + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dijkstra(i);
            int itemQuantity = 0;

            for (int j = 1; j <= cityQuantity; j++) {
                if (dist[j] <= seekBound) {
                    itemQuantity += items[j];
                }
            }

            max = Math.max(max, itemQuantity);
        }

        System.out.println(max);
    }

    public static void dijkstra(int startNode) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

        queue.add(new Edge(startNode, 0));
        dist[startNode] = 0;

        while (!queue.isEmpty()) {
            Edge target = queue.poll();

            if (target.getWeight() > dist[target.getEnd()]) {
                continue;
            }

            List<Edge> linkedEdges = graph.get(target.getEnd());

            if (linkedEdges != null) {
                for (Edge edge : linkedEdges) {
                    int nextNode = edge.getEnd();
                    if (target.getWeight() + edge.getWeight() < dist[nextNode]) {
                        dist[nextNode] = target.getWeight() + edge.getWeight();
                        queue.add(new Edge(nextNode, dist[nextNode]));
                    }
                }
            }
        }
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

