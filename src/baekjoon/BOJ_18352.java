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

public class BOJ_18352 {

    private static Map<Integer, List<Edge>> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int cityQuantity = Integer.parseInt(input[0]); //n
        int roadQuantity = Integer.parseInt(input[1]); //m
        int targetWeight = Integer.parseInt(input[2]);
        int startNode = Integer.parseInt(input[3]);

        graph = new HashMap<>();
        for (int i = 0; i < roadQuantity; i++) {
            input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            graph.putIfAbsent(start, new ArrayList<>());

            graph.get(start).add(new Edge(end, 1));
        }

        dist = new int[cityQuantity + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(startNode);

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= cityQuantity; i++) {
            if (dist[i] == targetWeight) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int cityNumber : answer) {
                System.out.println(cityNumber);
            }
        }
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
