package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_11779 {

    private static int cityQuantity;
    private static int busQuantity;
    private static int startCity;
    private static int destination;
    private static HashMap<Integer, List<Edge>> graph;
    private static int[] dist;
    private static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        cityQuantity = Integer.parseInt(bufferedReader.readLine());
        busQuantity = Integer.parseInt(bufferedReader.readLine());

        graph = new HashMap<>();
        for (int i = 1; i <= cityQuantity; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < busQuantity; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            graph.get(start).add(new Edge(end, weight));
        }

        String[] input = bufferedReader.readLine().split(" ");
        startCity = Integer.parseInt(input[0]);
        destination = Integer.parseInt(input[1]);
        dist = new int[cityQuantity + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        answer = new ArrayList<>();
        dijkstra();

        System.out.println(dist[destination]);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(startCity);
        queue.add(new Node(startCity, 0, tmp));
        dist[startCity] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.weight > dist[poll.end]) {
                continue;
            }

            if (poll.end == destination && poll.weight <= dist[destination]) {
                answer = poll.visited;
            }

            List<Edge> edges = graph.get(poll.end);
            for (Edge edge : edges) {
                if (poll.visited.contains(edge.end)) {
                    continue;
                }
                if (edge.weight + poll.weight < dist[edge.end]) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.addAll(poll.visited);
                    tempList.add(edge.end);
                    queue.add(new Node(edge.end, edge.weight + poll.weight, tempList));
                    dist[edge.end] = edge.weight + poll.weight;
                }
            }
        }
    }

    static class Node {

        int end;
        int weight;
        List<Integer> visited;

        public Node(int end, int weight, List<Integer> visited) {
            this.end = end;
            this.weight = weight;
            this.visited = visited;
        }
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

